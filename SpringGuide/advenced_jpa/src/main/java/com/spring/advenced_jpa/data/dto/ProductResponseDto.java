package com.spring.advenced_jpa.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {
    // 상품 번호
    private Long number;

    // 상품 이름
    private String name;

    // 상품 가격
    private int price;

    // 상품 재고
    private int stock;
}
