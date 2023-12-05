package com.cydeo.repository;

import com.cydeo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

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

    // Returns a user read by username.

    // Returns all users.

    // ----------------------- Native QUERIES ------------------ //

    // Returns all users that contain a specific name.

}
