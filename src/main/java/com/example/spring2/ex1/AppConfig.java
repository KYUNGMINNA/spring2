package com.example.spring2.ex1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration// 설정 정보라는 의미         3.
public class AppConfig {
    //구현 객체를 생성하고, 연결하는 책임을 가진 클래스

    /**                                   1.*/
    /*
    public MemberService memberService(){
        return  new MeberServiceImpl(new MemoryMemberRepository());
    }
    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(),new FixDiscountPolicy());
    }
    */

    /** 리팩토링                             2.*/
    /*
    public MemberService memberService(){
        return  new MeberServiceImpl(memberRepository());
    }
    public OrderService orderService(){
        return new OrderServiceImpl( memberRepository(), discountPolicy());
    }
    //추후에 다른 구현체를 쓰려면 new 부분만 다시 작성하면 된다
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    //추후에 다른 구현체를 쓰려면 new 부분만 다시 작성하면 된다
    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }
    */
    /** 스프링으로 전환하기                    3.*/
    // 스프링 컨테이너에 빈으로 등록한다.
    @Bean
    public MemberService memberService() {
        return new MeberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}
