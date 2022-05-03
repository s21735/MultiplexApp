package com.example.toukmultiplex.Reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;


interface ReservationRepository extends JpaRepository<Reservation,Long> {

    @Modifying
    @Query(value = "insert into reservation (Cost, Customer, ScreeningFK) values (:cost,:customer,:screeningfk)", nativeQuery = true)
    void saveReservation(@Param("cost") BigDecimal cost, @Param("customer")String customer, @Param("screeningfk")Long screeningfk );



}
