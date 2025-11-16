package com.example.ProductService.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category extends BaseModel{
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
