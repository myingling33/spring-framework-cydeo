package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    // Display all employees with email address containing something...
    List<Employee> findByEmail(String email);

    // Display all employees with first name ' ' and last name '  '; also, show all employees
    // with an email address
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName, String lastName, String email);

    // Display all employees whose first name is not ' '
    List<Employee> findByFirstNameIsNot(String firstName);

    // Display all employees where last name starts with ' '
    List<Employee> findByLastNameStartsWith(String pattern);

    // Display all employees with salaries higher than ' '
    List<Employee> findBySalaryGreaterThan(Integer salary);

    // Display all employees with salaries less than or equal to ' '
    List<Employee> findBySalaryLessThanEqual(Integer salary);

    // Display all employees that were hired between ' ' and ' '
    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);

    // Display all employees where salaries greater than and equal to ' ' in order
    List<Employee> findBySalaryIsGreaterThanEqualOrderBySalaryDesc(Integer salary);

    // Display top unique 3 employees that is making less than ' '
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    // Display all employees that do not have email address
    List<Employee> findByEmailIsNull();
}
