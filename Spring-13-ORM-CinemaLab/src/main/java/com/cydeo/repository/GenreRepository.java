package com.cydeo.repository;

import com.cydeo.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre,Long> {

    // ----------------------- JPQL QUERIES ------------------ //

    // Return all genres
    @Query("SELECT g FROM Genre g")
    List<Genre> fetchAll();

    // ----------------------- Native QUERIES ------------------ //

    // Returns genres by containing name
    @Query(value = "SELECT * FROM genre WHERE name ILIKE concat('%', ?1, '%')", nativeQuery = true)
    List<Genre> retrieveByName(String name);

}
