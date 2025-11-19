package com.example.ProductService.InheritanceDemo.MappedSuperClass;

import jakarta.persistence.Entity;

@Entity(name = "msc_mentor")
public class Mentor extends User{

    private String company;
    private Double avgRating;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(Double avgRating) {
        this.avgRating = avgRating;
    }
}
