package com.example.toukmultiplex.Reservation;

import lombok.*;
import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@Entity
@Getter
 class Movie {
   public Movie() {
   }

   @Id
    private Long id;
    private String title;
    private String description;
    private String genre;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private Set<Screening> screenings;
}
