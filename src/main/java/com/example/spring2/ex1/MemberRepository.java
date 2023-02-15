package com.example.spring2.ex1;

public interface MemberRepository {
    void save(Member member);
    Member findById(Long memberId);
}
