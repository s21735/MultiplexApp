package com.example.toukmultiplex.Reservation;

import com.example.toukmultiplex.Config.TicketProperties;
import com.example.toukmultiplex.Reservation.DTO.ReservationDataDto;
import com.example.toukmultiplex.Reservation.DTO.SeatDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
class AmountToPayService {

    private final TicketProperties ticketProperties;

    public AmountToPayService(TicketProperties ticketProperties) {
        this.ticketProperties = ticketProperties;
    }

    BigDecimal amountToPay(ReservationDataDto reservationDataDto) {
        List<SeatDTO> seatsList = reservationDataDto.getSeats();
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (SeatDTO reservationSeatsDTO : seatsList) {
            switch (reservationSeatsDTO.getTicketType()) {
                case adult:
                   totalPrice= totalPrice.add(ticketProperties.getAdultPrice()) ;
                    break;
                case student:
                    totalPrice= totalPrice.add(ticketProperties.getStudentPrice()) ;
                    break;
                case child:
                    totalPrice= totalPrice.add(ticketProperties.getChildPrice()) ;
                    break;
            }
        }
        return totalPrice;
    }
}