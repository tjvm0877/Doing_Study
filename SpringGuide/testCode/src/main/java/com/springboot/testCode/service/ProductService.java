package com.springboot.testCode.service;

import com.springboot.testCode.data.dto.ProductDto;
import com.springboot.testCode.data.dto.ProductResponseDto;
import com.springboot.testCode.data.repository.ProductRepository;

public interface ProductService {

    ProductResponseDto getProduct(Long number);

    ProductResponseDto saveProduct(ProductDto productDto);

    ProductResponseDto changeProductName(Long number, String name) throws Exception;

    void deleteProduct(Long number) throws Exception;
}
