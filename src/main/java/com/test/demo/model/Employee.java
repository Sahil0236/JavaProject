package com.test.demo.model;

import jakarta.annotation.Generated;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employee")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "dep_id")
    private Department dept;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    private Integer age;
    private Double salary;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;



}
