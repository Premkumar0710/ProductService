package com.example.ProductService.InheritanceDemo.TablePerClass;

import jakarta.persistence.Entity;

@Entity(name = "tpc_ta")
public class TA extends User {
    private Integer numberOfHelpRequests;
    private Double avgRating;

    public Integer getNumberOfHelpRequests() {
        return numberOfHelpRequests;
    }

    public void setNumberOfHelpRequests(Integer numberOfHelpRequests) {
        this.numberOfHelpRequests = numberOfHelpRequests;
    }

    public Double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(Double avgRating) {
        this.avgRating = avgRating;
    }
}
