package com.example.spring2.ex1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        //MemberService memberService=new MeberServiceImpl();     1.

        //AppConfig로 의존 관계를 주입
        //AppConfig appConfig=new AppConfig();                    //2.
        //MemberService memberService= appConfig.memberService(); //2.

        /** AppConfig에 있는 환경 설정 정보를 가지고
         * 해당 객체를 빈으로 스프링 컨테이너에 다 넣어준다.                3. */
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);

        // 해당 빈을 가져온다.
        MemberService memberService =applicationContext.getBean("memberService", MemberService.class);


        Member member=new Member(1L,"memberA",Grade.VIP);
        memberService.join(member);

        Member findMember=memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
