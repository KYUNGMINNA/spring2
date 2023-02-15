package com.example.spring2.ex1;

public interface DiscountPolicy {
    /**
     *
     * @param member
     * @param price
     * @return 할인 대상 금액
     */
    int discount(Member member,int price);
}
