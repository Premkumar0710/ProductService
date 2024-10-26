package com.example.ProductServiceJune24.InheritanceTypes.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue(value = "3") // converted to integer
public class Instructor extends User {
    private String subject;
}
