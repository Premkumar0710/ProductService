package com.example.ProductServiceJune24.InheritanceTypes.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue(value = "1") //converted to integer
public class Student extends User {
    private String batch;
}
