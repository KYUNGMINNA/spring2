package com.example.spring2.ex1;


public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        // 난 모르겠고 할인 정책은 할인 정책에게 넘긴다.
        int discountPrice = discountPolicy.discount(member, itemPrice);


        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}