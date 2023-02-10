package com.api.graphql.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_table")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String name;
    @Id
    private String emailAddress;
    private double monthlySalary;
    private double monthlyExpenses;
}
