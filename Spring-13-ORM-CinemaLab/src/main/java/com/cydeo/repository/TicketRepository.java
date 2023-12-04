package com.cydeo.repository;

import com.cydeo.entity.Ticket;
import com.cydeo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Long> {

    // ----------------------- DERIVED QUERIES ------------------ //

    // To count how many tickets a user bought.
    Integer countByUserAccountId(Long userId);

    // To list all tickets by specific email.
    List<Ticket> findAllByUserAccount_Email(String email);

    // To count how many tickets are sold for a specific movie name.
    Integer countAllByMovieCinema_Movie_Name(String name);

    // To list all tickets between a range of dates.
    List<Ticket> findByDateTimeBetween(LocalDateTime dateTime1, LocalDateTime dateTime2);

    // ----------------------- JPQL QUERIES ------------------ //

    // Returns all tickets bought from a specific user.
    @Query("SELECT t FROM Ticket t WHERE t.userAccount.id = ?1")
    List<Ticket> fetchAllTicketsByUserAccount(Long userId);

    // Returns all tickets between a range of dates.
    @Query("SELECT t FROM Ticket t WHERE t.dateTime BETWEEN ?1 AND ?2")
    List<Ticket> fetchAllTicketsBetweenRangeOfDateTimes(LocalDateTime dateTime1, LocalDateTime dateTime2);

    // ----------------------- Native QUERIES ------------------ //

    // To count the number of tickets a user bought.
    @Query(value = "SELECT COUNT(*) FROM ticket WHERE user_account_id = ?1", nativeQuery = true)
    Integer countAllTicketsByUserAccount(Long userId);

    // To count the number of tickets a user bought in a specific range of dates.
    @Query(value = "SELECT COUNT(*) FROM ticket WHERE user_account_id = ?1 AND date_time BETWEEN ?2 AND ?3", nativeQuery = true)
    Integer countTicketByUserInDateRange(Long userId, LocalDateTime dateTime1, LocalDateTime dateTime2);

    // To distinct all tickets by movie name.
    @Query(value = "SELECT DISTINCT(m.name) FROM ticket t JOIN movie_cinema mc ON t.movie_cinema_id = mc.id " +
            " JOIN movie m ON mc.movie_id = m.id", nativeQuery = true)
    List<String> retrieveAllDistinctMovieName();
    
    // To find all tickets by user email.
    @Query(value = "SELECT * FROM ticket t JOIN user_account ua ON t.user_account_id = ua.id WHERE ua.email = ?1", nativeQuery = true)
    List<Ticket> findAllByUserEmail(String email);

    // Returns all tickets.
    @Query(value = "SELECT * FROM ticket", nativeQuery = true)
    List<Ticket> retrieveAll();

    // To list all tickets where a specific value should be containable in the username or
    // account name or movie name.
    @Query(value = "SELECT * FROM ticket t JOIN user_account ua ON t.user_account_id = ua.id " +
            " JOIN account_details ad on ua.account_details_id = ad.id " +
            " JOIN movie_cinema mc on t.movie_cinema_id = mc.id " +
            " JOIN movie m on mc.movie_id = m.id WHERE ua.username ILIKE concat('%', ?1, '%') " +
            " OR ad.name ILIKE concat('%', ?1, '%') OR m.name ILIKE concat('%', ?1, '%')", nativeQuery = true)
    List<Ticket> retrieveAllBySearchCriteria(String keyword);


}

