package com.example.spring2.ex1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){
        //스프링에 등록된 모든 빈 이름을 조회
        String[] beanDefinitionNames=ac.getBeanDefinitionNames();
        for(String beanDefinition:beanDefinitionNames){
            //빈 이름으로 빈 객체 조회
            Object bean=ac.getBean(beanDefinition);
            System.out.println("beanDefinition = " + beanDefinition+", Object = "+bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력")
    void findApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames){
            BeanDefinition beanDefinition=ac.getBeanDefinition(beanDefinitionName);

            //ROLE_APPLICATION : 직접 등록한 애플리케이션의 빈
            //ROLE_INFRASTRUCTURE : 스프링 내부에서 사용하는 빈
            if (beanDefinition.getRole() ==BeanDefinition.ROLE_APPLICATION){
                Object bean=ac.getBean(beanDefinitionName);
                System.out.println("beanDefinitionName = " + beanDefinitionName+", Object ="+bean);
            }
        }
        /** 조회 대상 스프링 빈이 없으면 NoSuchBeanDefinitoinException 발생 */
    }

    @Test
    @DisplayName("이름 없이 타입으로 조회")
    void findBeanByType(){
        MemberService memberService=ac.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MeberServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2(){
        //기본적으로 인터페이시로 조회하면 인터페이스의 구현체가 조회 대상이 된다.
        //그래서 이렇게 직접 구현체로 빈을 가져올 수 있다.
        MemberService memberService=ac.getBean(MeberServiceImpl.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }/** 역할과 구현을 구분하고 역할에 의존해야 하기 때문에 좋은 방법 X */

    @Test
    @DisplayName("존재 하지않는 빈 이름으로 조회 ")
    void findBeanByNameFail(){
        assertThrows(NoSuchBeanDefinitionException.class,
                ()->ac.getBean("없는 빈", MeberServiceImpl.class));
    }
}