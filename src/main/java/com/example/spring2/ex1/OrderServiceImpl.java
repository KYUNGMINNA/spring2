package com.example.spring2.ex1;


public class OrderServiceImpl implements OrderService {

//    private final MemberRepository memberRepository = new MemoryMemberRepository();  4.
    private final MemberRepository memberRepository;                        //5.


    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();   1.
    //할인 정책을 변경하려면 인터페이스 구현 객체를 변경해야 하는 과정이 필요하다

    // +OOP의 개방-폐쇄 원칙(OCP)에 어긋난다. :확장에는 열려 있지만 ,변경에는 닫혀있어야 함
    // +의존관계 역전 원칙(DIP) : 구현클래스에 의존하지 않고 , 인터페이스에 의존해야 하지만
    // 구현클래스에 의존적이여서(어떤 클래스가 인터페이스를 구현했는지 알아야 함) DIP에 어긋난다
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();  2.

    //DIP를 지키기 위해 인터페이스에만 의존하도록 했지만, 구현체가 없어서 NPE가 발생한다.
    //구현 객체를 대신 생성하고 주입해줘야 NPE문제를 해결할 수 있다.
    //private DiscountPolicy discountPolicy;                                   4.

    private final DiscountPolicy discountPolicy;                            // 5.

    //외부인 AppConfig가 의존 관계를 주입해준다.
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        // 난 모르겠고 할인 정책은 할인 정책에게 넘긴다.
        int discountPrice = discountPolicy.discount(member, itemPrice);


        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}