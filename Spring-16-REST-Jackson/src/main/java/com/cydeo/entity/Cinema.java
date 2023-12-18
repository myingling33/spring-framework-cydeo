package com.cydeo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;

@Entity
public class Cinema extends BaseEntity {

    private String name;
    private String sponsoredName;

    @ManyToOne(fetch = FetchType.LAZY)
    private Location location;
}
