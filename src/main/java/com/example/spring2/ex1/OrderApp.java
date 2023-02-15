package com.example.spring2.ex1;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService=new MeberServiceImpl();
        OrderService orderService=new OrderServiceImpl();

        Long memberId=1L;
        Member member=new Member(memberId,"memberA",Grade.VIP);
        memberService.join(member);

        Order order=orderService.createOrder(memberId,"itemA",10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice() = " + order.calculatePrice());

    }
}
