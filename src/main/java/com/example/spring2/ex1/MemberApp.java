package com.example.spring2.ex1;

public class MemberApp {
    public static void main(String[] args) {
        //MemberService memberService=new MeberServiceImpl();     1.

        //AppConfig로 의존 관계를 주입
        AppConfig appConfig=new AppConfig();                    //2.
        MemberService memberService= appConfig.memberService(); //2.

        Member member=new Member(1L,"memberA",Grade.VIP);
        memberService.join(member);

        Member findMember=memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
