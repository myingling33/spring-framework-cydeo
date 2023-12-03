package com.cydeo.repository;

import com.cydeo.entity.Account;
import com.cydeo.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

    // ----------------------- DERIVED QUERIES ------------------ //

    // Write a derived query to list all accounts with a specific country or state
    List<Account> findByCountryOrState(String country, String state);

    // Write a derived query to list all accounts with age lower than or equal to a specific value
    List<Account> findByAgeLessThanEqual(Integer age);

    // Write a derived query to list all accounts with a specific role
    List<Account> findByRole(UserRole role);  // role is an Enum

    // Write a derived query to list all accounts between a range of ages
    List<Account> findByAgeBetween(Integer ageStart, Integer ageEnd);

    // Write a derived query to list all accounts where the beginning of the address
    // contains the keyword
    List<Account> findByAddressStartsWith(String keyword);

    // Write a derived query to sort the list of accounts with age
    List<Account> findByOrderByAgeDesc();

    // ----------------------- JPQL QUERIES ------------------ //

    // Write a JPQL query that returns all accounts.
    @Query("SELECT a FROM Account a")
    List<Account> fetchAllAccounts();

    // Write a JPQL query to list all admin accounts.
    @Query("SELECT a FROM Account a WHERE a.role = 'ADMIN'")
    List<Account> fetchAdminAccounts();

    // Write a JPQL query to sort all accounts with age ascending.
    @Query("SELECT a FROM Account a ORDER BY a.age")
    List<Account> fetchAllOrderByAge();

}
