package pinguPinguEat.logic;

import pinguPinguEat.reservationModel.Reservation;
import pinguPinguEat.reservationModel.ReservationSystem;
import pinguPinguEat.reservationModel.Table;
import pinguPinguEat.reservationModel.TimeSlot;
import pinguPinguEat.restaurants.CuisineType;
import pinguPinguEat.restaurants.PriceCategory;
import pinguPinguEat.restaurants.Restaurant;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class MyReservationLogic {
    //Hier wird die Logic für Reservation eingefügt, damit in dem Controller nicht zu viel Text ist
    public static List<Reservation> getAllReservations() {
        List<Reservation> res = new ArrayList<>();
        res.add(new Reservation(new TimeSlot(LocalTime.of(1,1,1)),
                new Table(1, 2) ,
                new Restaurant("AmazingDiner", CuisineType.GERMAN, PriceCategory.INEXPENSIVE,
                        new ReservationSystem(0, 0))));
        res.add(new Reservation(new TimeSlot(LocalTime.of(1,1,1)),
                new Table(5, 3) ,
                new Restaurant("Blue Whale Restaurant", CuisineType.ITALIAN, PriceCategory.EXPENSIVE,
                        new ReservationSystem(5, 8))));
        return res;
    }
}
