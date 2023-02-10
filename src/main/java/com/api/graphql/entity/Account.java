package com.api.graphql.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "account_table")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountId;
    private String accountType;
    private String userId;
}
