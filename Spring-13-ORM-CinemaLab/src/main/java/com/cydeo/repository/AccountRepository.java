package com.cydeo.repository;

import com.cydeo.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account,Long> {

    // ----------------------- DERIVED QUERIES ------------------ //

    // Write a derived query to list all accounts with a specific country or state
    List<Account> findByCountryOrState(String countryState);

    // Write a derived query to list all accounts with age lower than or equal to a specific value

    // Write a derived query to list all accounts with a specific role

    // Write a derived query to list all accounts between a range of ages

    // Write a derived query to list all accounts where the beginning of the address
    // contains the keyword

    // Write a derived query to sort the list of accounts with age



}
