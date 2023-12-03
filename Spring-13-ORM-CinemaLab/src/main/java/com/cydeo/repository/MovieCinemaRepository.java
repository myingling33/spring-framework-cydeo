package com.cydeo.repository;

import com.cydeo.entity.MovieCinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface MovieCinemaRepository extends JpaRepository<MovieCinema,Long> {
    // ----------------------- DERIVED QUERIES ------------------ //

    // To read movie cinema with id.
    Optional<MovieCinema> findById(Long id);

    // To count all movie cinemas with a specific cinema id.
    Integer countByCinemaId(Long id);

    // To count all movie cinemas with a specific movie id.
    Integer countByMovieId(Long id);

    // To list all movie cinemas with higher than a specific date.
    List<MovieCinema> findByDateTimeAfter(LocalDateTime dateTime);

    // To find the top 3 expensive movies.
    List<MovieCinema> findTop3ByOrderByMoviePriceDesc();

    // To list all movie cinemas that contain a specific movie name.
    List<MovieCinema> findByMovie_NameContaining(String name);

    // To list all movie cinemas in a specific location name.
    List<MovieCinema> findByCinema_Location_Name(String name);

    // ----------------------- JPQL QUERIES ------------------ //

    // To list all movie cinemas with higher than a specific date.
    @Query("SELECT mc FROM MovieCinema mc WHERE mc.dateTime > ?1")
    List<MovieCinema> fetchByDateHigher(LocalDateTime dateTime);

    // ----------------------- Native QUERIES ------------------ //



}
