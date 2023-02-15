package com.example.spring2.ex1;

public interface MemberService {
    void join(Member member);
    Member findMember(Long memberId);

}
