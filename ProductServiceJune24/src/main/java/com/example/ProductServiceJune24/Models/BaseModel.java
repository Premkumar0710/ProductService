package com.example.ProductServiceJune24.Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

// This class will have all the frequently used variables
@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id // id is taken as primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment
    private long id;
    private Date createdAt;
    private Date updatedAt;
}
