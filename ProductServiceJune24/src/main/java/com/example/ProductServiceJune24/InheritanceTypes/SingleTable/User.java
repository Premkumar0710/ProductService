package com.example.ProductServiceJune24.InheritanceTypes.SingleTable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "user_type",
        discriminatorType = DiscriminatorType.INTEGER // Enum's
)
@DiscriminatorValue(value = "0") //converted to integer
public class User {
    @Id
    private long id;
    private String name;
    private String email;

}
