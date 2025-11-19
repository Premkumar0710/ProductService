package com.example.ProductService.InheritanceDemo.JoinedTable;

import jakarta.persistence.Entity;

@Entity(name = "jt_ta")
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
