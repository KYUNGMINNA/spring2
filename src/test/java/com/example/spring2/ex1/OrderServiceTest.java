package com.example.spring2.ex1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    //MemberService memberService=new MeberServiceImpl();       1.
    //OrderService orderService=new OrderServiceImpl();         1.

    MemberService memberService;                              //2.
    OrderService orderService;                                //2.
    @Test
    void createOrder(){
        Long memberId=1L;
        Member member=new Member(memberId,"memberA",Grade.VIP);
        memberService.join(member);

        Order order=orderService.createOrder(memberId,"itemA",10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

    @BeforeEach
    void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

}