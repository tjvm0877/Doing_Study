package spring.doitmyself.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spring.doitmyself.domain.Member;
import spring.doitmyself.repository.MemberRepository;
import spring.doitmyself.repository.MemoryMemberRepository;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository repository;
    //    MemoryMemberRepository repository = new MemoryMemberRepository();
    
    @BeforeEach
    public void beforEach() {
        repository = new MemoryMemberRepository();
        memberService = new MemberService(repository);
    }
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    void join() { // 회원가입
        // given - 이것이 주어졌을 때
        Member member = new Member();
        member.setName("Hyun");

        // when - 이것을 실행했을 때
        long saveID = memberService.join(member);

        // then - 결과가 이것이 나온다.
        Member findMember = memberService.findOne(saveID).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void validateDuplicateMember() {
        // given
        Member member1 = new Member();
        member1.setName("Hyun");

        Member member2 = new Member();
        member2.setName("Hyun");

        // when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원 이름입니다.");
    }
}