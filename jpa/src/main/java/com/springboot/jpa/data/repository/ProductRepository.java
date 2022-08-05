package com.springboot.jpa.data.repository;

import com.springboot.jpa.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/*
Spring Data JPA는 JpaRepository를 기반으로 더욱 쉽게 데이터베이스를 사용할 수 있는 아키텍처를 제공
JpaRepository를 상속하는 인터페이스를 생성해 기존의 메소드를 활용할 수 있음
*/
public interface ProductRepository extends JpaRepository<Product, Long> {

}
