package com.example.ProductServiceJune24.InheritanceTypes.TablePerClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tbc_instructor")
public class Instructor extends User {
    private String subject;
}
