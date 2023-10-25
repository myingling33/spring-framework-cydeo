package com.cydeo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee { //employee

    @Id
    private int id;
    private String name;
}
