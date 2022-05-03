package com.example.toukmultiplex.Reservation;

import com.example.toukmultiplex.Reservation.DTO.ReservationDataDto;
import com.example.toukmultiplex.Reservation.ReservationValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class JunitTestValidatorAtLeastOneSeat {
    @Test
    public void check_if_at_least_one_seat_booked(){
    //given
        ReservationValidator reservationValidator = new ReservationValidator(null,null,null);

    //when
        boolean flag = reservationValidator.checkIfAtLeastOneSeatBooked(reservationData());

     //then
        Assertions.assertTrue(flag);


    }
    private ReservationDataDto reservationData() {
        ReservationDataDto mock = Mockito.mock(ReservationDataDto.class);
        List testList = new ArrayList();
        testList.add(new Object());
        Mockito.when(mock.getSeats()).thenReturn(testList);

        return mock;
    }
}
