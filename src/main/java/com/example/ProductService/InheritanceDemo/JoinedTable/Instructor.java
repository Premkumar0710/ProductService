package com.example.ProductService.InheritanceDemo.JoinedTable;

import jakarta.persistence.Entity;

@Entity(name = "jt_instructor")
public class Instructor extends User {

    private String subject;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
