package com.cydeo.repository;

import com.cydeo.model.Employee;

public class DBEmployeeRepository implements EmployeeRepository{

    // Assume we are getting this data from the DB
    public int getHourlyRate() {
        Employee employee = new Employee("Harold Finch", "IT", 65);

        return employee.getHourlyRate();
    }
}
