package com.hyun.springproject.service;

import com.hyun.springproject.domain.Member;
import com.hyun.springproject.repository.MemberRepository;
import com.hyun.springproject.repository.impl.MemberRepositoryImpl;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemberRepositoryImpl();

    /* 회원 가입 */
    public Long join(Member member) {

        validateDuplicateMember(member); // 중복 회원 검증

        memberRepository.save(member);
        return member.getId();
    }

    /* 전체 회원 조회 */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원 입니다.");
                });
    }
}
