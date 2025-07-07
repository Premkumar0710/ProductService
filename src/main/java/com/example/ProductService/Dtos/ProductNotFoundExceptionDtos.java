package com.example.ProductService.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductNotFoundExceptionDtos {
    private String message;
    private String resolution;
    private Long productId;
}
