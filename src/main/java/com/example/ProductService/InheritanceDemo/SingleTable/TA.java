package com.example.ProductService.InheritanceDemo.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity // creating new name is of no use because its going to be added in a single table
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue(value = "3")
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
