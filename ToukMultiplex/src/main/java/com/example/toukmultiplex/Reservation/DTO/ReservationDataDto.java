package com.example.toukmultiplex.Reservation.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ReservationDataDto {
    public ReservationDataDto() {
    }

    String firstName;
    String lastName;
    List<SeatDTO> seats;

}
