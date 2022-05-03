package com.example.toukmultiplex.Reservation;

import com.example.toukmultiplex.Reservation.DTO.MovieTitleAndScreeningTimeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.Set;

interface ScreeningRepository extends JpaRepository<Screening, Long> {


    @Query(value = "select title as movieName, screeningdate as screeningDate, id as screeningId from Screening inner join movie on screening.movie_idmovie = movie.idmovie where screeningdate between :t1 and :t2  order by movie.title, screeningdate", nativeQuery = true)
    Set<MovieTitleAndScreeningTimeDTO> findByScreeningDateBetween(@Param("t1")Timestamp timestamp1, @Param("t2")Timestamp timestamp2);



}
