package spring.doitmyself.repository;
import spring.doitmyself.domain.Member;

import java.util.List;
import java.util.Optional;


public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findByID(long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
