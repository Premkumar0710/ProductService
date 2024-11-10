package com.example.ProductServiceJune24.Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

// This class will have all the frequently used variables
@Getter
@Setter
@MappedSuperclass
public class BaseModel implements Serializable {
    @Id // id is taken as primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment
    private Long id; // here we are using object Long bcoz we are passing this in Product Repo as generics
    private Date createdAt;
    private Date updatedAt;
}
