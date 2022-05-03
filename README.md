# MultiplexApp
założenia:
1. There cannot be a single place left over in a row between two already reservedplaces to wymagania 
wydało mi się ekstremalnie zagmatwane, i nierealizowalne w żaden sensowny sposób więc je pominąłem.

uruchomienie:
*trzeba mieć zainstalowanego dockera
*najpierw uruchomić plik docker-compose który utworzy kontener posgresowy 





strzały ScreeningController:

1) listAvailableScreeningByDate
GET localhost:8080/api/screenings

{
    "beginTimestamp": "2021-04-15 10:10:25.000",
    "endTimestamp": "2024-04-16 10:10:25.000"
}


2) returnAvailableSeatsOnGivenScreeningById

GET llocalhost:8080/api/screenings/details/1

================================================================
strzały ReservationController

1) GET localhost:8080/api/reservation/data/11

{
    "firstName": "Janś",
    "lastName":"Kowalskiś",
    "seats": [
        {"id": 10,"row":"a", "seatNumber":1, "roomNumber":1,"screeningfk":11,"ticketType":"adult"},
        {"id":11,"row":"a", "seatNumber":2, "roomNumber":1,"screeningfk":11,"ticketType":"adult"},
      {"id": 12,"row":"a", "seatNumber":2, "roomNumber":1,"screeningfk":11,"ticketType":"adult"}

    ]

}

