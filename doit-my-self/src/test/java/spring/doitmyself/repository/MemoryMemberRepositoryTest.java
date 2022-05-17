package spring.doitmyself.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import spring.doitmyself.domain.Member;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @Test
    void save() {
        Member member = new Member();
        member.setName("Jae_Hyun");

        repository.save(member);

        Member result = repository.findByID(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    void findByID() {
        Member member = new Member();
        member.setName("Hyun");

        repository.save(member);

        Member result = repository.findByID(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    void findByName() {
        Member member1 = new Member();
        member1.setName("Kim1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Kim2");
        repository.save(member2);

        Member result = repository.findByName("Kim1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    void findAll() {
        Member member1 = new Member();
        member1.setName("Hyun");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Kin");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}