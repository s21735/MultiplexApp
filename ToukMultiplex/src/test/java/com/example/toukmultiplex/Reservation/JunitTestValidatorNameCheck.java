package com.example.toukmultiplex.Reservation;

import com.example.toukmultiplex.Reservation.DTO.ReservationDataDto;
import com.example.toukmultiplex.Reservation.ReservationValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class JunitTestValidatorNameCheck {

    @Test
    public void should_return_true_if_firstName_and_lastName_are_correct_name_1() {

        //given
        ReservationValidator reservationValidator = new ReservationValidator(null,null,null);

        //when
        boolean testName = reservationValidator.checkIfNameAndLastNameCorrect(NameMockCorrect1());

        //then
        Assertions.assertTrue(testName);

    }

    @Test
    public void should_return_true_if_firstName_and_lastName_are_correct_name_2() {

        //given
        ReservationValidator reservationValidator = new ReservationValidator(null,null,null);

        //when
        boolean testName = reservationValidator.checkIfNameAndLastNameCorrect(NameMockCorrect2());

        //then
        Assertions.assertTrue(testName);

    }

    @Test
    public void should_return_false_firstName_and_lastName_are_incorrect_name_1() {

        //given
        ReservationValidator reservationValidator = new ReservationValidator(null,null,null);

        //when
        boolean testName = reservationValidator.checkIfNameAndLastNameCorrect(NameMockIncorrect1());

        //then
        Assertions.assertFalse(testName);

    }

    @Test
    public void should_return_false_firstName_and_lastName_are_incorrect_name_2() {

        //given
        ReservationValidator reservationValidator = new ReservationValidator(null,null,null);

        //when
        boolean returnValue = reservationValidator.checkIfNameAndLastNameCorrect(NameMockIncorrect2());

        //then
        Assertions.assertFalse(returnValue);

    }

    @Test
    public void should_return_false_firstName_and_lastName_are_incorrect_name_3() {

        //given
        ReservationValidator reservationValidator = new ReservationValidator(null,null,null);

        //when
        boolean testName = reservationValidator.checkIfNameAndLastNameCorrect(NameMockIncorrect3());

        //then
        Assertions.assertFalse(testName);

    }


    private ReservationDataDto NameMockCorrect1(){
        ReservationDataDto mock = Mockito.mock(ReservationDataDto.class);
        Mockito.when(mock.getFirstName()).thenReturn("Jan");
        Mockito.when(mock.getLastName()).thenReturn("Kowalski");
        Mockito.when(mock.getSeats()).thenReturn(null);
        return mock;
    }
    private ReservationDataDto NameMockCorrect2(){
        ReservationDataDto mock = Mockito.mock(ReservationDataDto.class);
        Mockito.when(mock.getFirstName()).thenReturn("Janś");
        Mockito.when(mock.getLastName()).thenReturn("Kowa-Lski");
        Mockito.when(mock.getSeats()).thenReturn(null);
        return mock;
    }

    private ReservationDataDto NameMockIncorrect1() {
        ReservationDataDto mock = Mockito.mock(ReservationDataDto.class);
        Mockito.when(mock.getFirstName()).thenReturn("Ja");
        Mockito.when(mock.getLastName()).thenReturn("Kow");
        Mockito.when(mock.getSeats()).thenReturn(null);
        return mock;
    }

    private ReservationDataDto NameMockIncorrect2() {
        ReservationDataDto mock = Mockito.mock(ReservationDataDto.class);
        Mockito.when(mock.getFirstName()).thenReturn("jan");
        Mockito.when(mock.getLastName()).thenReturn("kowalski");
        Mockito.when(mock.getSeats()).thenReturn(null);
        return mock;
    }

    private ReservationDataDto NameMockIncorrect3() {
        ReservationDataDto mock = Mockito.mock(ReservationDataDto.class);
        Mockito.when(mock.getFirstName()).thenReturn("Jan");
        Mockito.when(mock.getLastName()).thenReturn("Kowal-ski");
        Mockito.when(mock.getSeats()).thenReturn(null);
        return mock;
    }


}
