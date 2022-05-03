package com.example.toukmultiplex.Reservation;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
 class Reservation {

    public Reservation() {
    }

    @Id
    Long IdReservation;
    BigDecimal Cost;
    String Customer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ScreeningFK")
    @JsonIgnore
    private Reservation reservation;



}
