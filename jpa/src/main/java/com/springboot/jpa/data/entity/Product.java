package com.springboot.jpa.data.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

/*
DB의 테이블에 대응하는 클래스

엔티티에는 데이터 DB에 쓰일 테이블과 칼럼을 정의,
엔티티에 어노테이션을 사용하면 테이블 간의 연관관계를 정의할 수 있음

spring.jpa.hibernate.ddl-auto값을 create로 했기 때문에 쿼리문을 따로 작서하지 않아도
매 실행마다 기존 테이블을 Drop하고 새로 생성함
 */

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number; // 상품번호

    @Column(nullable = false)
    private String name; // 상품이름

    @Column(nullable = false)
    private Integer price; // 상품 가격

    @Column(nullable = false)
    private Integer stock; // 상품 재고

    private LocalDateTime createdAt; // 상품 생성 일자

    private LocalDateTime updatedAt; // 상품 정보 변경 일자

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
