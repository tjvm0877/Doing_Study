package spring.doitmyself.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import spring.doitmyself.domain.Member;
import spring.doitmyself.repository.MemoryMemberRepository;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService = new MemberService();
    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();

    @Test
    void join() {
        Member member = new Member();
        member.setName("Hyun");

        long saveID = memberService.join(member);

        Member findMember = memberService.findOne(saveID).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

}