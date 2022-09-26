package com.spring.advenced_jpa.data.dto;

import lombok.*;

@Data // @Getter + @Setter + @RequiredArgsConstructor + @ToString + @EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {

    // 상품 이름
    private String name;

    // 상품 가격
    private int price;

    // 상품 재고
    private int stock;
}
