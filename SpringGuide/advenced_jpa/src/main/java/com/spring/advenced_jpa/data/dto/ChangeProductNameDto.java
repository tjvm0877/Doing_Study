package com.spring.advenced_jpa.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/* 상품 이름 변경을 위한 Dto */
@Getter
@Setter
@AllArgsConstructor
public class ChangeProductNameDto {
    // 상품 번호
    private Long number;

    // 상품 이름
    private String name;
}
