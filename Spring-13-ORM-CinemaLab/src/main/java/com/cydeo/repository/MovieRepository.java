package com.cydeo.repository;

import com.cydeo.entity.Movie;
import com.cydeo.enums.MovieState;
import com.cydeo.enums.MovieType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie,Long> {

    // ----------------------- DERIVED QUERIES ------------------ //

    // To read a movie with a name.
    Optional<Movie> findByName(String name);

    // To list all movies between a range of prices.
    List<Movie> findByPriceBetween(BigDecimal priceStart, BigDecimal priceEnd);

    // To list all movies where duration exists in the specific list of duration.
    List<Movie> findByDurationIn(List<Integer> durations);

    // To list all movies with higher than a specific release date.
    List<Movie> findByReleaseDateAfter(LocalDate releaseDate);

    // To list all movies with a specific state and type.
    List<Movie> findByStateAndType(MovieState state, MovieType type);


    // ----------------------- JPQL QUERIES ------------------ //

    // To list all movies between a range of prices.
    @Query("SELECT m from Movie m WHERE m.price BETWEEN ?1 AND ?2")
    List<Movie> getByPriceBetween(BigDecimal priceStart, BigDecimal priceEnd);

    // That returns all movie names.
    @Query("SELECT m.name from Movie m")
    List<String> fetchAllMovieNames();

    // ----------------------- Native QUERIES ------------------ //

    // That returns a movie by name.
    @Query(value = "SELECT * FROM movie WHERE name = ?1", nativeQuery = true)
    Optional<Movie> retrieveByName(String name);

    // That returns the list of movies in a specific range of prices.
    @Query(value = "SELECT * FROM movie WHERE price BETWEEN ?1 AND ?2", nativeQuery = true)
    List<Movie> retrieveByPriceRange(BigDecimal price1, BigDecimal price2);

    // Return all movies where duration exists in the range of duration.
    @Query(value = "SELECT * FROM movie WHERE duration IN ?1", nativeQuery = true)
    List<Movie> retrieveByDurationInRange(List<Integer> durations);

    // List the top 5 most expensive movies.
    @Query(value = "SELECT * FROM movie ORDER BY price DESC LIMIT 5", nativeQuery = true)
    List<Movie> top5ExpensiveMovies();
}
