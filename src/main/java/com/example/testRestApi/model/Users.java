package com.example.testRestApi.model;

import lombok.*;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "surName", nullable = false)
    private String surName;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "imageUrl", nullable = false)
    private String imageUrl;
    @Column(name = "status", nullable = false)
    private String status;
}
