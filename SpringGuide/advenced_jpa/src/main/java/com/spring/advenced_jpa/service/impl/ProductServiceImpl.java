package com.spring.advenced_jpa.service.impl;

import com.spring.advenced_jpa.data.dto.ProductDto;
import com.spring.advenced_jpa.data.dto.ProductResponseDto;
import com.spring.advenced_jpa.data.entity.Product;
import com.spring.advenced_jpa.data.repository.ProductRepository;
import com.spring.advenced_jpa.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProductServiceImpl implements ProductService {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /* 상품 조회 */
    @Override
    public ProductResponseDto getProduct(Long number) {
        LOGGER.info("[getProduct] input number : {}", number);
        Product product = productRepository.findById(number).get();

        LOGGER.info("[getProduct] product number : {}, name : {}", product.getNumber(), product.getName());
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setNumber(product.getNumber());
        productResponseDto.setName(product.getName());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setStock(product.getStock());

        return productResponseDto;
    }

    /* 상품 저장 */
    @Override
    public ProductResponseDto saveProduct(ProductDto productDto) {
        LOGGER.info("[saveProduct] productDto number: {}", productDto.toString());
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());

        Product savedProduct = productRepository.save(product);
        LOGGER.info("[saveProduct] savedProduct : {}", savedProduct);

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setNumber(savedProduct.getNumber());
        productResponseDto.setName(savedProduct.getName());
        productResponseDto.setPrice(savedProduct.getPrice());
        productResponseDto.setStock(savedProduct.getStock());

        return productResponseDto;
    }

    /* 상품 이름 변경 */
    @Override
    public ProductResponseDto changeProductName(Long number, String name) throws Exception {
        LOGGER.info("[changeProductName] number : {}, Name : {}", number, name);
        Product foundProduct = productRepository.findById(number).get();
        foundProduct.setName(name);
        Product changedProduct = productRepository.save(foundProduct);

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setNumber(changedProduct.getNumber());
        productResponseDto.setName(changedProduct.getName());
        productResponseDto.setPrice(changedProduct.getPrice());
        productResponseDto.setStock(changedProduct.getStock());

        return productResponseDto;
    }

    /* 상품 삭제 */
    @Override
    public void deleteProduct(Long number) throws Exception {
        productRepository.deleteById(number);
    }
}
