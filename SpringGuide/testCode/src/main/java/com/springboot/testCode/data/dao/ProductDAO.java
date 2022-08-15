package com.springboot.testCode.data.dao;

import com.springboot.testCode.data.entity.Product;

public interface ProductDAO {

    // 상품 입력
    Product insertProduct(Product product);

    // 상품 선택
    Product selectProduct(Long number);

    // 상품 정보 수정
    Product updateProductName(Long number, String name) throws Exception;

    // 상품 삭제
    void deleteProduct(Long number) throws Exception;
}
