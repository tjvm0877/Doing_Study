package com.spring.advenced_jpa.service;

import com.spring.advenced_jpa.data.dto.ProductDto;
import com.spring.advenced_jpa.data.dto.ProductResponseDto;

public interface ProductService {

    // 상품 조회
    ProductResponseDto getProduct(Long number);

    // 상품 저장(생성)
    ProductResponseDto saveProduct(ProductDto productDto);

    // 상품 이름 변경
    ProductResponseDto changeProductName(Long number, String name) throws Exception;

    // 상품 삭제
    void deleteProduct(Long number) throws Exception;
}
