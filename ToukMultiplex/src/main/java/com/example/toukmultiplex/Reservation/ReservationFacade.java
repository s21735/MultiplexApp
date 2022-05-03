package com.example.toukmultiplex.Reservation;
import com.example.toukmultiplex.Reservation.DTO.*;
import com.example.toukmultiplex.Reservation.DTO.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;

@Service
public class ReservationFacade {

    private final ScreeningRepository screeningRepository;
    private final ReservationValidator reservationValidator;
    private final AmountToPayService amountToPayService;
    private final ReservationRepository reservationRepository;
    private final SeatRepository seatRepository;
    private final ComputeReservationTimeArrival reservationTimeArrival;


    public ReservationFacade(ScreeningRepository screeningRepository, ReservationValidator reservationValidator, AmountToPayService amountToPayService, ReservationRepository reservationRepository, SeatRepository seatRepository, ComputeReservationTimeArrival reservationTimeArrival) {
        this.screeningRepository = screeningRepository;
        this.reservationValidator = reservationValidator;
        this.amountToPayService = amountToPayService;
        this.reservationRepository = reservationRepository;
        this.seatRepository = seatRepository;
        this.reservationTimeArrival = reservationTimeArrival;
    }


    public Iterable<MovieTitleAndScreeningTimeDTO> MoviesAndTimeOfScreeningByGivenTime(TimeInterval timeinterval){
        Timestamp beginTimestamp = Timestamp.valueOf(timeinterval.getBeginTimestamp());
        Timestamp endTimestamp = Timestamp.valueOf(timeinterval.getEndTimestamp());
        return screeningRepository.findByScreeningDateBetween(beginTimestamp,endTimestamp);
    }

    public Set<Seat> returnInformationOnAvailableSeatsByGivenScreeningId(Long Id) {
         return seatRepository.findByIdAndTakenFalse(Id);
    }
    
    @Transactional
    public ReservationSummaryDTO makeReservation(ReservationDataDto reservationDataDto, Long id)  {

        reservationValidator.recievedReservationDataValidator(reservationDataDto, id);
        BigDecimal price = amountToPayService.amountToPay(reservationDataDto);
        String customer = reservationDataDto.getFirstName()+" "+ reservationDataDto.getLastName();
        reservationRepository.saveReservation(price, customer, id);

        for (int i=0;i<reservationDataDto.getSeats().size();i++) {
            seatRepository.updateSeatsInformation(
                    reservationDataDto.getSeats().get(i).getid(),
                    reservationDataDto.getSeats().get(i).getTicketType().toString() );
        }

        Timestamp timeArrival = reservationTimeArrival.computeReservationTimeArrival(id);

        return new ReservationSummaryDTO(price, timeArrival);
    }
}
