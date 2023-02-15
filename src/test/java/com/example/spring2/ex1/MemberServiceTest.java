package com.example.spring2.ex1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    private MemberService memberService=new MeberServiceImpl();
    @Test
    void join() {
        //given
        Member memberA = new Member(1L, "memberA", Grade.VIP);

        //when
        memberService.join(memberA);
        Member findMember = memberService.findMember(memberA.getId());

        //then
        Assertions.assertThat(memberA).isEqualTo(findMember);
    }
}