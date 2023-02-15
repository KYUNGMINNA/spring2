package com.example.spring2.ex1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    DiscountPolicy discountPolicy=new RateDiscountPolicy();
    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_discount(){
        //given
        Member member=new Member(1L,"memberVIP",Grade.VIP);

        //when
        int discount=discountPolicy.discount(member,10000);

        //then
        Assertions.assertThat(discount).isEqualTo(1000);

    }
    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    void not_vip(){
        //given
        Member member=new Member(1L,"memberBasic",Grade.BASIC);

        //when
        int discount=discountPolicy.discount(member,10000);

        //then
        Assertions.assertThat(discount).isEqualTo(0);
    }

}