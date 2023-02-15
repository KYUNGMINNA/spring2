package com.example.spring2.ex1;

public class MeberServiceImpl implements MemberService{

    //인터페이스의 구현체가 없으면 NPE

    //MemberRepository 인터페이스를 구현하는 클래스가 변경이 있을 때 , 그 클래스 파일도 제작해야 하고
    //구현체 클래스에 맞게 Service에서도 변경이 일어나야한다.
    //private final MemberRepository memberRepository=new MemoryMemberRepository();    1.

    private final  MemberRepository memberRepository;

    public MeberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
