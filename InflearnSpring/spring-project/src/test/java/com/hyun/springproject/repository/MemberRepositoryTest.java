package com.hyun.springproject.repository;

import com.hyun.springproject.domain.Member;
import com.hyun.springproject.repository.impl.MemberRepositoryImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberRepositoryTest {

    MemberRepositoryImpl repository = new MemberRepositoryImpl();

    // 각 테스트가 끝날때 마다 저장되어있던 데이터 삭제
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    @DisplayName("회원 등록(save) 테스트")
    public void save() {
        Member member = new Member();
        member.setName("hyun");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
//        System.out.println("result = " + (result == member));
        assertThat(member).isEqualTo(result);
    }

    @Test
    @DisplayName("Name으로 회원 조회 테스트")
    public void findByName() {
        Member member1 = new Member();
        member1.setName("member1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("member2");
        repository.save(member2);

        Member result = repository.findByName("member1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    @DisplayName("ID로 회원 조회 테스트")
    public void findById() {
        Member member = new Member();
        member.setName("member");
        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    @DisplayName("모든 회원 조회 테스트")
    public void findAll() {
        Member member1 = new Member();
        member1.setName("member1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("member2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
