package pinguPinguEat.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import pinguPinguEat.logic.MyReservationLogic;
import pinguPinguEat.reservationModel.Reservation;

import java.io.IOException;

public class ReservationGroupController {
    private ObservableList<Reservation> userReservations = FXCollections.observableArrayList();
    @FXML // fx:id="reservationList"
    private ListView<Reservation> reservationList; // Value injected by FXMLLoader
    public ReservationGroupController() {

    };


    public void loadList() throws IOException {
        userReservations.addAll(MyReservationLogic.getAllReservations());
        reservationList.setItems(userReservations);
    }
}
