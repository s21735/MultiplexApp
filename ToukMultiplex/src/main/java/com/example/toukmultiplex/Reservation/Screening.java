package com.example.toukmultiplex.Reservation;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@AllArgsConstructor
@Getter
class Screening {
    public Screening() { }

    @Id
    private Long id;
    private Timestamp screeningDate;
    private int Movie_IdMovie;

    @OneToMany(mappedBy = "screening")
    private Set<Seat> seats;

    @OneToMany(mappedBy = "reservation")
    private Set<Reservation> reservations;
}
