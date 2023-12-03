package com.cydeo.repository;

import com.cydeo.entity.Cinema;
import com.cydeo.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CinemaRepository extends JpaRepository<Cinema,Long> {

    // ----------------------- DERIVED QUERIES ------------------ //

    // To get cinema with a specific name
    Optional<Cinema> findByName(String name);

    // To read sorted the top 3 cinemas that contain a specific sponsored name
    List<Cinema> findTop3BySponsoredNameContainingOrderBySponsoredName(String sponsoredName);

    // To list all cinemas in a specific country
    List<Cinema> findByLocation_Country(String country);

    // To list all cinemas with a specific name or sponsored name
    List<Cinema> findByNameOrSponsoredName(String name, String sponsoredName);

    // ----------------------- JPQL QUERIES ------------------ //

    // To read the cinema name with a specific id.
    @Query("SELECT c.name FROM Cinema c WHERE c.id = ?1")
    String fetchById(Long id);

    // ----------------------- Native QUERIES ------------------ //

    // To read all cinemas by location country.

    // To read all cinemas by name or sponsored name contains a specific pattern

    // To sort all cinemas by name

    // To distinct all cinemas by sponsored name















}
