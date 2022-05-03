CREATE TABLE Movie (
                       IdMovie bigserial  NOT NULL,
                       title varchar(150)  NOT NULL,
                       Description varchar(1500)  NOT NULL,
                       Genre varchar(200)  NOT NULL,
                       CONSTRAINT Movie_pk PRIMARY KEY  (IdMovie)
);


CREATE TABLE Reservation (
                             IdReservation bigserial  NOT NULL,
                             Cost decimal  NOT NULL,
                             Customer varchar(300)  NOT NULL,
                             ScreeningFK int  NOT NULL,
                             CONSTRAINT Reservation_pk PRIMARY KEY  (IdReservation)
);


CREATE TABLE Screening (
                           id bigserial  NOT NULL,
                           screeningDate timestamp NOT NULL,
                           Movie_IdMovie int  NOT NULL,
                           CONSTRAINT Screening_pk PRIMARY KEY  (id)
);


CREATE TABLE Seat (
                      id bigserial  NOT NULL,
                      Row char(1)  NOT NULL,
                      SeatNumber int  NOT NULL,
                      roomNumber int  NOT NULL,
                      taken boolean NOT NULL,
                      ScreeningFK int  NOT NULL,
                      ticketType varchar,
                      CONSTRAINT Seat_pk PRIMARY KEY  (id)
);


CREATE TABLE "user" (
                        id bigserial  NOT NULL,
                        firstName varchar(90)  NOT NULL,
                        lastName varchar(90)  NOT NULL,
                        login varchar(90)  NOT NULL,
                        passwordHashed varchar(290)  NOT NULL,
                        CONSTRAINT user_pk PRIMARY KEY  (id)
);



ALTER TABLE Reservation ADD CONSTRAINT Reservation_Screening
    FOREIGN KEY (ScreeningFK)
        REFERENCES Screening (id);

ALTER TABLE Screening ADD CONSTRAINT Screening_Movie
    FOREIGN KEY (Movie_IdMovie)
        REFERENCES Movie (IdMovie);

ALTER TABLE Seat ADD CONSTRAINT Seat_Screening
    FOREIGN KEY (ScreeningFK)
        REFERENCES Screening (id);

