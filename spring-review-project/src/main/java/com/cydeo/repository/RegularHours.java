package com.cydeo.repository;

import org.springframework.stereotype.Component;

@Component
public class RegularHours implements HoursRepository{

    public int getHours() {
        return 40;
    }
}
