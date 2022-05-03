package com.example.toukmultiplex.Reservation.DTO;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class ReservationSummaryDTO {
    public BigDecimal price;
    public Timestamp expirationTime;

    public ReservationSummaryDTO(BigDecimal price, Timestamp expirationTime) {
        this.price = price;
        this.expirationTime = expirationTime;
    }
}
