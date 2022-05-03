package com.example.toukmultiplex.Reservation;
import com.example.toukmultiplex.Reservation.DTO.MovieTitleAndScreeningTimeDTO;
import com.example.toukmultiplex.Reservation.DTO.SeatDTO;
import com.example.toukmultiplex.Reservation.DTO.TimeInterval;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@RequestMapping(path="api/screenings")
 class ScreeningController {

private final ReservationFacade reservationFacade;

    public ScreeningController(ReservationFacade reservationFacade) {
        this.reservationFacade = reservationFacade;
    }

    @GetMapping
    public Iterable<MovieTitleAndScreeningTimeDTO> listAvailableScreeningByDate(@RequestBody TimeInterval timeinterval) {
        return reservationFacade.MoviesAndTimeOfScreeningByGivenTime(timeinterval);
    }

    @GetMapping("details/{id}")
    public Set<Seat> returnAvailableSeatsOnGivenScreeningById(@PathVariable("id") Long id) {
        return reservationFacade.returnInformationOnAvailableSeatsByGivenScreeningId(id);
    }

}
