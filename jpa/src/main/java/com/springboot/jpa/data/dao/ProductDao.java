package com.springboot.jpa.data.dao;

import com.springboot.jpa.data.entity.Product;

/*
DAO 클래스는 의존석을 낮추기 위한 디자인 패턴
일반적으로 '인터페이스-구현체'의 형태로 생성

일반적으로 데이터베이스에 접근하는 메서드는 리턴값으로 데이터 객체(여기서는 Product)를 전달,
이때 데이터 객체를 엔티티 객체로 전달할지, DTO객체로 전달할지에 대해서는 사바사,
일반적인 설계 원칙에서 엔티티 객체는 데이터베이스에 접근하는 계층에서만 사용하도록 정의
 */
public interface ProductDao {

    Product insertProduct(Product product);

    Product selectProduct(Long number);

    Product updateProductName(Long number, String Name) throws Exception;

    void deleteProduct(Long number) throws Exception;
}
