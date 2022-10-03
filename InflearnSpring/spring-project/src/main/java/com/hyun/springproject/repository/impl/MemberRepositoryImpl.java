package com.hyun.springproject.repository.impl;

import com.hyun.springproject.domain.Member;
import com.hyun.springproject.repository.MemberRepository;

import java.util.*;

public class MemberRepositoryImpl implements MemberRepository {

    // 메모리에 저장하기 위한 저장소
    private static Map<Long, Member> store = new HashMap<>();

    // 자동으로 키값을 만드어주기 위한 변수
    private static Long sequence = 0L;

    @Override

    public Member save(Member member) {

        // 시퀀스 값을 증가 시켜주고 id로 설정
        member.setId(++sequence);
        // id와 이름을 store라는 메모리 저장소에 등록
        store.put(member.getId(), member);

        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        // null값을 반환할 수 있기 때문에 Optional로 감싸줌
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        // 람다함수로 store의 모든 값을 순회, 같은 값을 반환하고 같은값이 없다면 null을 반환
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
