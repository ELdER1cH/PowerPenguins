package pinguPinguEat.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import pinguPinguEat.logic.MyReservationLogic;
import pinguPinguEat.reservationModel.Reservation;

import java.io.IOException;
import java.util.Optional;

public class ReservationGroupController {
    private ObservableList<Reservation> userReservations = FXCollections.observableArrayList();
    @FXML // fx:id="reservationList"
    private ListView<Reservation> reservationList; // Value injected by FXMLLoader
    public ReservationGroupController() {

    };


    public void loadList() throws IOException {
        userReservations.addAll(MyReservationLogic.getAllReservations());
        reservationList.setItems(userReservations);

        reservationList.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Reservation thisReservation = reservationList.getSelectionModel().getSelectedItem();
                // this way the popup doesn't appear if it's already confirmed
                if (!thisReservation.isConfirmable()) {
                    return;
                }

                Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
                confirm.setTitle("Confirmation");
                confirm.setHeaderText(null);
                confirm.setContentText("Confirm this reservation?");
                Optional<ButtonType> answer = confirm.showAndWait();
                if (answer.get() == ButtonType.OK) {
                    thisReservation.confirm();
                }
                System.out.println("name: " + reservationList.getSelectionModel().getSelectedItems().toString());
            }
        });
    }
}
