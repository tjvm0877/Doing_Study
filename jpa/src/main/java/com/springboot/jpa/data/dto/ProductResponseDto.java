package com.springboot.jpa.data.dto;

public class ProductResponseDto {
    private Long number;
    private String name;
    private int price;

    public ProductResponseDto(Long number, String name, int price) {
        this.number = number;
        this.name = name;
        this.price = price;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
