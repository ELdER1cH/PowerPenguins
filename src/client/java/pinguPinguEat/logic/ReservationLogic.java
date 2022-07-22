package pinguPinguEat.logic;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pinguPinguEat.controller.ReservationController;

import pinguPinguEat.reservationElement.Reservation;
import pinguPinguEat.reservationElement.ReservationSystem;
import pinguPinguEat.reservationElement.Table;
import pinguPinguEat.reservationElement.TimeSlot;
import pinguPinguEat.restaurantElement.CuisineType;
import pinguPinguEat.restaurantElement.PriceCategory;
import pinguPinguEat.restaurantElement.Restaurant;

import pinguPinguEat.view.SceneView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReservationLogic {

    private final ObservableList<Reservation> reservationObservableList;
    private final SceneView sceneView;
    private final ReservationController reservationController;  
  
    public ReservationLogic() {
        this.reservationController = new ReservationController();
        this.sceneView = new SceneView();
        this.reservationObservableList = FXCollections.observableArrayList();

//        initiate reservationObservableList


    }
  
    //Hier wird die Logic für Reservation eingefügt, damit in dem Controller nicht zu viel Text ist
    public static List<Reservation> getAllReservations() {
        List<Reservation> res = new ArrayList<>();
        res.add(new Reservation(new TimeSlot(LocalDateTime.of(1, 2, 3, 12, 13)),
                new Table(1, 2) ,
                new Restaurant("AmazingDiner","address", CuisineType.GERMAN, PriceCategory.INEXPENSIVE, "great",
                        new ReservationSystem(0, 0), "3.-3", "help",8)));
        res.add(new Reservation(new TimeSlot(LocalDateTime.of(2022, 7, 11, 23, 13)),
                new Table(5, 3) ,
                new Restaurant("Blue Whale Restaurant","address", CuisineType.ITALIAN, PriceCategory.EXPENSIVE, "awful",
                        new ReservationSystem(5, 8), "3.-3", "help", 9)));
        res.add(new Reservation(new TimeSlot(LocalDateTime.of(1980, 7, 11, 23, 13)),
                new Table(5, 3) ,
                new Restaurant("WCDarnalds", "addresio", CuisineType.ITALIAN, PriceCategory.INEXPENSIVE, "nice",
                        new ReservationSystem(5, 8), "3.-3", "help", 5)));
        return res;
    }

    private void setReservation(List<Reservation> reservation) {
        Platform.runLater(() -> reservationObservableList.setAll(reservation));
    }

    //  FR5: Save calendar event: When the user reserves a table,
//  an event in the local calendar is created for the reservation.
    public void createCalendarEvent() {

    }

//    FR6: Confirm reservation: A user is reminded about a reservation one day
//    before the actual date of the reservation and must confirm it
//    until latest 12 hours before the actual date.
//    If the user does not confirm, his reservation is cancelled automatically.


//    FR7: Cancel reservation: A user can cancel his reservation at any time up to two twelve hours
//    before the actual date of the reservation.
//    After the confirmation (see FR5), the user cannot cancel the reservation anymore.

}
