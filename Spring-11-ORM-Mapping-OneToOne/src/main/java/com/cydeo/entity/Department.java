package com.cydeo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "departments")
@NoArgsConstructor
@Data
public class Department extends BaseEntity {

    private String department;
    private String division;

    @OneToOne(mappedBy = "department") // keeps from creating a second foreign key
    private Employee employee;

    public Department(String department, String division) {
        this.department = department;
        this.division = division;
    }
}
