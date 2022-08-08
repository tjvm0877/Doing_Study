package spring.doitmyself.repository;

import spring.doitmyself.domain.Member;

import java.lang.reflect.Array;
import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; // long 데이터 유형의 값 뒤에 L을 작성하여 long 값을 나타냄

    @Override
    public Member save(Member member) { // 저장
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findByID(long id) { // ID로 찾기
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) { // 이름으로 찾기
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() { // 모든 리스트로 가져오기
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}