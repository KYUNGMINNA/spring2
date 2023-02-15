package com.example.spring2.ex1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

public class ApplicationContextSameBeanTest {

    AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("타입으로 조회할 때 둘 이상 있으면 중복 오류가 발생")
    void findBeanByTypeDuplicate(){
        MemberRepository bean=ac.getBean(MemberRepository.class);
    }/** 같은 타입을 반환하는 빈이 2개면 NoUniqueBeanDefinitionException 예외 발생 */

    //테스트용 설정 클래스
    @Configuration
    static class SameBeanConfig{
        @Bean
        public MemberRepository memberRepository(){
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberRepository memberRepository2(){
            return new MemoryMemberRepository();
        }
    }

    @Test
    @DisplayName("타입으로 조회할 때 같은 타입 둘 이상이면 빈 이름일 지정해서 불러온다")
    void findBeanByName(){
        MemberRepository memberRepository=ac.getBean("memberRepository",MemberRepository.class);
        Assertions.assertThat(memberRepository).isInstanceOf(MemberRepository.class);
    }

    @Test
    @DisplayName("특정 타입의 빈을 모두 조회")
            void findAllBeanByType() {

        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);

        for (String key : beansOfType.keySet()){
            System.out.println("key = " + key+" value="+beansOfType.get(key));
        }

        System.out.println("beansOfType = " + beansOfType);
        Assertions.assertThat(beansOfType.size()).isEqualTo(2);
    }
}
