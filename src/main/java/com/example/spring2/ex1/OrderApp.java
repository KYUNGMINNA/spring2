package com.example.spring2.ex1;

public class OrderApp {
    public static void main(String[] args) {
        //MemberService memberService=new MeberServiceImpl();       //1.
        //OrderService orderService=new OrderServiceImpl();         //1.

        AppConfig appConfig = new AppConfig();                      //2.
        MemberService memberService = appConfig.memberService();    //2.
        OrderService orderService = appConfig.orderService();       //2.

        Long memberId=1L;
        Member member=new Member(memberId,"memberA",Grade.VIP);
        memberService.join(member);

        Order order=orderService.createOrder(memberId,"itemA",10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice() = " + order.calculatePrice());

    }
}
