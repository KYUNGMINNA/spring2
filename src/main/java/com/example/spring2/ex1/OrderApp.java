package com.example.spring2.ex1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
        //MemberService memberService=new MeberServiceImpl();       //1.
        //OrderService orderService=new OrderServiceImpl();         //1.

        //AppConfig appConfig = new AppConfig();                      //2.
        //MemberService memberService = appConfig.memberService();    //2.
        //OrderService orderService = appConfig.orderService();       //2.

        /**     xml :GenericXmlApplicationContext                       3. */
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);


        Long memberId=1L;
        Member member=new Member(memberId,"memberA",Grade.VIP);
        memberService.join(member);

        Order order=orderService.createOrder(memberId,"itemA",10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice() = " + order.calculatePrice());

    }
}
