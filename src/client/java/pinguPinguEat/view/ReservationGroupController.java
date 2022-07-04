package pinguPinguEat.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import pinguPinguEat.logic.MyReservationLogic;
import pinguPinguEat.reservationModel.Reservation;

import java.io.IOException;

public class ReservationGroupController {
    private ObservableList<Reservation> user_reservations = FXCollections.observableArrayList();
    @FXML // fx:id="reservationList"
    private ListView<Reservation> reservationList; // Value injected by FXMLLoader
    public ReservationGroupController(){};


    public void loadList() throws IOException {
//        FXMLLoader loader = new FXMLLoader(ClientApplication.class.getResource("ReservationGroupView.fxml"));
//        Group reservationViewGroup = loader.load();

        ObservableList<Reservation> user_reservations = FXCollections.observableArrayList();
        user_reservations.addAll(MyReservationLogic.getUserReservations());
        reservationList.setItems(user_reservations);
    }
}
