package com.example.ProductService.InheritanceDemo.MappedSuperClass;

import jakarta.persistence.Entity;

@Entity(name = "msc_instructor")
public class Instructor extends User{

    private String subject;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
