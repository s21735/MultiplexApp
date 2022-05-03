package com.example.toukmultiplex.Reservation;

import com.example.toukmultiplex.Config.ReservationProperties;
import com.example.toukmultiplex.Reservation.DTO.ReservationDataDto;
import com.example.toukmultiplex.Reservation.DTO.SeatDTO;
import com.example.toukmultiplex.Reservation.Exception.ValidationException;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ReservationValidator {
    private final ScreeningRepository screeningRepository;
    private final SeatRepository seatRepository;
    private final ReservationProperties reservationProperties;

    public ReservationValidator(ScreeningRepository screeningRepository, SeatRepository seatRepository, ReservationProperties reservationProperties) {
        this.screeningRepository = screeningRepository;
        this.seatRepository = seatRepository;
        this.reservationProperties = reservationProperties;
    }

     boolean checkIfNameAndLastNameCorrect(ReservationDataDto reservationDataDto) {

         if (Character.isLowerCase(reservationDataDto.getFirstName().charAt(0)) || reservationDataDto.getFirstName().length()<3 ||
                 Character.isLowerCase(reservationDataDto.getLastName().charAt(0)) || reservationDataDto.getLastName().length()<3) {
             return false;
         } else if (reservationDataDto.getLastName().contains("-")) {
             String[] partsOfLastName = reservationDataDto.getLastName().split("-");
             return Character.isUpperCase(partsOfLastName[1].charAt(0));
         }
         return true;
    }

    boolean checkIfScreeningExists(Long id) {
        Optional<Screening> screening = screeningRepository.findById(id);
        return screening.isPresent();
    }

    boolean checkIfTimeLeftToScreeningIsValid(Screening screening) {

        long NUMBER_OF_SECONDS_IN_MINUTE = 60L;
        Timestamp ExpireLimitBookingMinutesAfterNow =
                Timestamp.from(Instant.now().plusSeconds(reservationProperties.getExpireLimitBookingMinutes()* NUMBER_OF_SECONDS_IN_MINUTE));
        return screening.getScreeningDate().after(ExpireLimitBookingMinutesAfterNow);

    }

    boolean checkIfAtLeastOneSeatBooked(ReservationDataDto reservationDataDto) {
        return reservationDataDto.getSeats().size() >= 1;
    }

    boolean checkIfSeatsAreAvailable(ReservationDataDto reservationDataDto){

         Set<Long> allTakenSeatsId = seatRepository.getSeatByTakenTrue().stream().map(SeatDTO::getid).collect(Collectors.toSet());
         Set<Long> allSeatsToBeCheckedId = reservationDataDto.getSeats().stream().map(SeatDTO::getid).collect(Collectors.toSet());

        return allTakenSeatsId.stream().noneMatch(allSeatsToBeCheckedId::contains);

    }

    void recievedReservationDataValidator(ReservationDataDto reservationDataDto, Long id) {
        if(!checkIfScreeningExists(id)) {
            throw new ValidationException("Taki screening nie istnieje!");
        }

        if(!checkIfTimeLeftToScreeningIsValid(screeningRepository.getById(id))) {
            throw new ValidationException("Projekcja zaczyna się zbyt szybko by zarezerwować!");
        }

        if(!checkIfNameAndLastNameCorrect(reservationDataDto)) {
            throw new ValidationException("Błąd w pisowni imienia lub nazwiska!");
        }

        if(!checkIfAtLeastOneSeatBooked(reservationDataDto)) {
            throw new ValidationException("Nie zarezerwowano żadnego miejsca!");
        }
        if(!checkIfSeatsAreAvailable(reservationDataDto)) {
            throw new ValidationException("Miejsca są zajęte!");
        }
    }





}
