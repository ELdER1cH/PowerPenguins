package pinguPinguEat.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import pinguPinguEat.logic.MyReservationLogic;
import pinguPinguEat.reservationModel.Reservation;

import java.util.Optional;

public class ReservationGroupController {
    private ObservableList<Reservation> userReservations = FXCollections.observableArrayList();
    @FXML // fx:id="reservationList"
    private ListView<Reservation> reservationList; // Value injected by FXMLLoader
    @FXML // fx:id="confirmButton"
    private Button confirmButton; // Value injected by FXMLLoader
    @FXML // fx:id="cancelButton"
    private Button cancelButton; // Value injected by FXMLLoader

    public ReservationGroupController() {
        userReservations.addAll(MyReservationLogic.getAllReservations());
    };

    public void loadList() {
        reservationList.setItems(userReservations);
    }

    private void update(ObservableList<Reservation> reservations, Reservation updatedReservation) {
        // this may seem overcomplicated but this was necessary for some reason
        reservations.removeIf(x -> x.getReservationId().equals(updatedReservation.getReservationId()));
        reservations.add(updatedReservation);
        reservationList.setItems(reservations);
    }

    public void confirmButtonPressed() {
        Reservation thisReservation = reservationList.getSelectionModel().getSelectedItem();
        if (thisReservation == null) {
            return;
        }
        if (!thisReservation.isConfirmable()) {
            return;
        }

        if (promptConfirmation().equals(ButtonType.OK)) {
            thisReservation.confirm();
            update(userReservations, thisReservation);
        }
    }

    public ButtonType promptConfirmation() {
        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("Confirmation");
        confirm.setHeaderText(null);
        confirm.setContentText("Confirm this reservation?");
        Optional<ButtonType> answer = confirm.showAndWait();
        return answer.get();
    }

    public void cancelButtonPressed() {
        Reservation thisReservation = reservationList.getSelectionModel().getSelectedItem();
        if (thisReservation == null) {
            return;
        }
        if (!thisReservation.isCancelable()) {
            alertCancellationImpossible();
            return;
        }
        userReservations.removeIf(x -> x.getReservationId().equals(thisReservation.getReservationId()));
        reservationList.setItems(userReservations);
    }

    private void alertCancellationImpossible() {
        Alert denial = new Alert(Alert.AlertType.INFORMATION);
        denial.setTitle("Cancellation impossible");
        denial.setHeaderText(null);
        denial.setContentText("You cannot cancel this reservation any longer.");
        denial.showAndWait();
    }
}


