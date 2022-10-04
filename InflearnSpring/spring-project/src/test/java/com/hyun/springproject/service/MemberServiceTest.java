package com.hyun.springproject.service;

import com.hyun.springproject.domain.Member;
import com.hyun.springproject.repository.impl.MemberRepositoryImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


class MemberServiceTest {

    MemberService memberService;
    MemberRepositoryImpl memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemberRepositoryImpl();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void join() {
        // given
        Member member = new Member();
        member.setName("member");

        // when
        Long savedId = memberService.join(member);

        // then
        Member finedMember = memberService.findOne(savedId).get();
        assertThat(member.getName()).isEqualTo(finedMember.getName());
    }

    @Test
    public void validateNameTest() {
        // given
        Member member1 = new Member();
        member1.setName("member1");

        Member member2 = new Member();
        member2.setName("member1");

        // when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원 입니다.");
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}