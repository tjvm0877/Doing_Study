package spring.doitmyself.service;

import spring.doitmyself.domain.Member;
import spring.doitmyself.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    public MemberRepository memberRepository;

    public long join(Member member) {
        //이름 중복 확인
        validateDuplicateMember(member);

        //회원 가입
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원 이름입니다.");
                });
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberID) {
        return memberRepository.findByID(memberID);
    }
}
