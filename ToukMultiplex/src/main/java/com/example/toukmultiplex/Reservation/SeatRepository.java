package com.example.toukmultiplex.Reservation;

import com.example.toukmultiplex.Reservation.DTO.SeatDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface SeatRepository extends JpaRepository<Seat, Long> {

    @Modifying
    @Query(value="update seat set taken = true, tickettype=:tickettype where id =:seatId", nativeQuery = true)
    void updateSeatsInformation
            ( @Param("seatId")Long seatId, @Param("tickettype") String tickettype);

    List<SeatDTO> getSeatByTakenTrue();

    @Query(value="select * from Seat\n" +
            "where taken = false\n" +
            "and\n" +
            "roomnumber= (select distinct roomnumber from screening\n" +
            "             inner join seat on screening.id = seat.screeningfk where screening.id = :id)", nativeQuery = true)
    Set<Seat> findByIdAndTakenFalse(Long id);

}
