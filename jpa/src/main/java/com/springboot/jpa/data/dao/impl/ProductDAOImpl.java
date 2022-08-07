package com.springboot.jpa.data.dao.impl;

import com.springboot.jpa.data.dao.ProductDAO;
import com.springboot.jpa.data.entity.Product;
import com.springboot.jpa.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class ProductDAOImpl implements ProductDAO {

    // 리포지터리 정의, 생성자 생성을 통해 의존성 주입
    @Autowired
    private final ProductRepository productRepository;
    public ProductDAOImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // 인터페이스에서 정의된 메소드 구현
    // Product 엔티티를 데이터베이스에 저장
    @Override
    public Product insertProduct(Product product) {
        Product saveProduct = productRepository.save(product);

        return saveProduct;
    }

    // 조회 메소드
    @Override
    public Product selectProduct(Long number) {
        Product selectedProduct = productRepository.getReferenceById(number);

        return selectedProduct;
    }

    // Product 데이터의 상품명을 업데이트하는 기능
    @Override
    public Product updateProductName(Long number, String name) throws Exception {
        Optional<Product> selectedProduct = productRepository.findById(number);

        Product updateProduct;
        if (selectedProduct.isPresent()) {
            Product product = selectedProduct.get();

            product.setName(name);
            product.setUpdatedAt(LocalDateTime.now());

            updateProduct = productRepository.save(product);
        } else {
            throw new Exception();
        }
        return updateProduct;
    }



    @Override
    public void deleteProduct(Long number) throws Exception {
        Optional<Product> selectedProduct = productRepository.findById(number);

        if (selectedProduct.isPresent()) {
            Product product = selectedProduct.get();

            productRepository.delete(product);
        } else {
            throw new Exception();
        }
    }
}
