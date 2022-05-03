package com.example.toukmultiplex.Reservation;

import com.example.toukmultiplex.Reservation.DTO.ReservationDataDto;
import com.example.toukmultiplex.Reservation.DTO.ReservationSummaryDTO;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="api/reservation")
 class ReservationController {
    private final ReservationFacade reservationFacade;

    public ReservationController(ReservationFacade reservationFacade ) {
        this.reservationFacade = reservationFacade;
    }

    @GetMapping("/data/{id}")
    ReservationSummaryDTO getReservationData(@RequestBody ReservationDataDto reservationDataDto, @PathVariable("id") Long id)   {
        return reservationFacade.makeReservation(reservationDataDto, id);
    }
}
