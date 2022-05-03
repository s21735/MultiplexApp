package com.example.toukmultiplex.Reservation;

import com.example.toukmultiplex.Config.ReservationProperties;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;

@Service
public class ComputeReservationTimeArrival {

    private final ScreeningRepository screeningRepository;
    private final ReservationProperties reservationProperties;

    public ComputeReservationTimeArrival(ScreeningRepository screeningRepository, ReservationProperties reservationProperties) {
        this.screeningRepository = screeningRepository;
        this.reservationProperties = reservationProperties;
    }

    public Timestamp computeReservationTimeArrival(Long id){

       Timestamp screeningTime;
       Timestamp reservationTimeArrival = Timestamp.from(Instant.now());

       Optional<Screening> screening = screeningRepository.findById(id);
       screeningTime= screening.get().getScreeningDate();
        reservationTimeArrival = Timestamp.from(screeningTime.toInstant().minusSeconds(reservationProperties.getExpireLimitOfAppearingInPersonMinutes()*60L));
        return reservationTimeArrival;
    }
}
