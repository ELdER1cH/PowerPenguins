package pinguPinguEat.logic;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import pinguPinguEat.controller.ReservationController;
import pinguPinguEat.reservationModel.Reservation;
import pinguPinguEat.reservationModel.ReservationSystem;
import pinguPinguEat.reservationModel.Table;
import pinguPinguEat.reservationModel.TimeSlot;
import pinguPinguEat.restaurants.CuisineType;
import pinguPinguEat.restaurants.PriceCategory;
import pinguPinguEat.restaurants.Restaurant;
import pinguPinguEat.view.SceneController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReservationLogic {
  
    private final ObservableList<Reservation> reservationObservableList;
    private final SceneController sceneController;
    private final ReservationController reservationController;  
  
    public ReservationLogic() {
        this.reservationController = new ReservationController();
        this.sceneController = new SceneController();
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
                        new ReservationSystem(5, 8), "3.-3", "help",9)));
        return res;
    }
  



    private void setReservation(List<Reservation> reservation) {
        Platform.runLater(() -> reservationObservableList.setAll(reservation));
    }

    //    FR4: Reserve table: A user can see the times when he can reserve a table in the chosen restaurant.
    public void showFreeTimeSlots() {

    }

    //    After clicking on the time, the user sees an overview of all tables in the restaurant.
    public void showOverviewOfAllTablesInChosenRestaurant() {

    }

    public void markAvailableTablesInOverview() {

    }

    //    He can choose the exact table the free one in the overview
//    and thus reserve the table for the specified number of visitors.
    // "on action" method for the exact table the free one in the overview
    public void chooseTable(ActionEvent event) {
        reservaTable();
    }

    private Boolean reservaTable() {
//        Todo
        setSpecifiedNumberOfVisitors();
        return false;
    }

    private void setSpecifiedNumberOfVisitors() {

    }

    //  FR5: Save calendar event: When the user reserves a table,
//  an event in the local calendar is created for the reservation.
    public void createCalendarEvent() {
        if (reservaTable()) {
            //        Todo

        }
    }

//    FR6: Confirm reservation: A user is reminded about a reservation one day
//    before the actual date of the reservation and must confirm it
//    until latest 12 hours before the actual date.
//    If the user does not confirm, his reservation is cancelled automatically.


//    FR7: Cancel reservation: A user can cancel his reservation at any time up to two twelve hours
//    before the actual date of the reservation.
//    After the confirmation (see FR5), the user cannot cancel the reservation anymore.

}
