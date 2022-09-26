package com.spring.advenced_jpa.data.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "product")
@ToString
public class Product {

    // 상품 번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;

    // 상품 이름
    @Column(nullable = false)
    private String name;

    // 상품 가격
    @Column(nullable = false)
    private int price;

    // 상품 재고
    @Column(nullable = false)
    private int stock;

    // 생성 날짜
    private LocalDateTime createdAt;

    // 업데이트 날짜
    private LocalDateTime updatedAt;
}
