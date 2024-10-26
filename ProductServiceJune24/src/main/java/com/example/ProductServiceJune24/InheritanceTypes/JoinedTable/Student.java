package com.example.ProductServiceJune24.InheritanceTypes.JoinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_students")
@PrimaryKeyJoinColumn(name = "user_id") // foreign key
public class Student extends User{
    private String batch;
}
