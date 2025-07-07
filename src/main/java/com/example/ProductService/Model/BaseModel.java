package com.example.ProductService.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseModel {
    private Long id;
    private String createdAt;
    private String lastUpdatedAt;
}
