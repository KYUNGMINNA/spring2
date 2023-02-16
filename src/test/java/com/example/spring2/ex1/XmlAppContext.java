package com.example.spring2.ex1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class XmlAppContext {

    @Test
    void xmlAppContext(){
        ApplicationContext ac =
                new GenericXmlApplicationContext("appConfig.xml");

        MemberService memberService =
                ac.getBean("memberService", MemberService.class);

        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
