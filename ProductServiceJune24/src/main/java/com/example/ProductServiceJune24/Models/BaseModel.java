package com.example.ProductServiceJune24.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

// This class will have all the frequently used variables
@Getter
@Setter
public class BaseModel {
    private long id;
    private Date createdAt;
    private Date updatedAt;
}
