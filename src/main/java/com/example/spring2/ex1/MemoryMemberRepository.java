package com.example.spring2.ex1;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryMemberRepository implements MemberRepository{

    //동시성 이슈로 ,실무에서 ConcurrentHashMap()을 쓰는게 좋다.
    private static Map<Long,Member> store=new HashMap<>();
    @Override
    public void save(Member member) {
        store.put(member.getId(),member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
