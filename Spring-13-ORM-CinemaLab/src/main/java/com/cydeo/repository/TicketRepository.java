package com.cydeo.repository;

import com.cydeo.entity.Ticket;
import com.cydeo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

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

    // Returns all tickets between a range of dates.

    // ----------------------- Native QUERIES ------------------ //

    // To count the number of tickets a user bought.

    // To count the number of tickets a user bought in a specific range of dates.
}

