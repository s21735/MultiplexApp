package com.example.toukmultiplex.Reservation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;

@AllArgsConstructor
@Entity
@Getter
class Seat {
     public Seat() {
     }

     @Id
     private Long id;
     private char Row;
     private int SeatNumber;
     private int roomNumber;
     private boolean taken;

     @Enumerated(EnumType.STRING)
     private TicketType ticketType;

     @ManyToOne(fetch = FetchType.EAGER)
     @JoinColumn(name = "ScreeningFK")
     @JsonIgnore
     private Screening screening;
}
