package com.cydeo.repository;

import com.cydeo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    // ----------------------- DERIVED QUERIES ------------------ //

    // Read a user with an email.
    Optional<User> findByEmail(String email);

    // Read a user with a username.
    Optional<User> findByUsername(String username);

    // List all users that contain a specific name.
    List<User> findByAccountNameContaining(String name);

    // List all users that contain a specific name in the ignore case mode.
    List<User> findByAccountNameContainingIgnoreCase(String name);

    // List all users with an age greater than a specified age.
    List<User> findByAccount_AgeGreaterThan(Integer age);


    // ----------------------- JPQL QUERIES ------------------ //

    // Returns a user read by email.
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    Optional<User> fetchByEmail(String email);

    // Returns a user read by username.
    @Query("SELECT u FROM User u WHERE u.username = ?1")
    Optional<User> fetchByUsername(String username);

    // Returns all users.
    @Query("SELECT u FROM User u")
    List<User> fetchAllUsers();

    // ----------------------- Native QUERIES ------------------ //

    // Returns all users that contain a specific name.
    @Query(value = "SELECT * FROM user_account ua JOIN account_details ad " +
            " ON ua.account_details_id = ad.id WHERE ad.name ILIKE concat('%', ?1, '%')", nativeQuery = true)
    List<User> retrieveAllByName(String name);

    // Returns all users.
    @Query(value = "SELECT * FROM user_account", nativeQuery = true)
    List<User> retrieveAll();

    // Returns all users in the range of ages.
    @Query(value = "SELECT * FROM user_account ua JOIN account_details ad " +
            " ON ua.account_details_id = ad.id " +
            " WHERE ad.age BETWEEN ?1 AND ?2", nativeQuery = true)
    List<User> retrieveBetweenAgeRange(Integer age1, Integer age2);

    // Read a user by email.
    @Query(value = "SELECT * FROM user_account WHERE email = ?1", nativeQuery = true)
    Optional<User> retrieveByEmail(String email);
}
