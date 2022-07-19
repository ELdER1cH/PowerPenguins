package pinguPinguEat.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import pinguPinguEat.logic.ReservationLogic;
import pinguPinguEat.reservationModel.Reservation;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ReservationGroupView {
    private ObservableList<Reservation> userReservations = FXCollections.observableArrayList();
    @FXML // fx:id="reservationList"
    private ListView<Reservation> reservationList; // Value injected by FXMLLoader
    @FXML // fx:id="confirmButton"
    private Button confirmButton; // Value injected by FXMLLoader
    @FXML // fx:id="cancelButton"
    private Button cancelButton; // Value injected by FXMLLoader

    public ReservationGroupView() {
        userReservations.addAll(ReservationLogic.getAllReservations());
    };

    public void loadList() {
        loadFromObservableList(userReservations);
    }

    public void loadFromObservableList(ObservableList<Reservation> source) {
        reservationList.setItems(sortByDate(source));
    }

    private ObservableList<Reservation> sortByDate(ObservableList<Reservation> sortee) {
        // idk why but this doesn't work with .stream().toList()
        List<Reservation> sorteeList = sortee.subList(0, sortee.size());
        Comparator<Reservation> compByTime = (r1, r2) -> (r1.getTimeSlot()).compareTo(r2.getTimeSlot());
        Collections.sort(sorteeList, new Comparator<Reservation>() {
            @Override
            public int compare(Reservation o1, Reservation o2) {
                return (o1.getTimeSlot()).compareTo(o2.getTimeSlot());
            }
        });
        return FXCollections.observableArrayList(sorteeList);
    }

    private void update(ObservableList<Reservation> reservations, Reservation updatedReservation) {
        // this may seem overcomplicated but this was necessary for some reason
        reservations.removeIf(x -> x.getReservationId().equals(updatedReservation.getReservationId()));
        reservations.add(updatedReservation);
        loadFromObservableList(reservations);
    }

    public void confirmButtonPressed() {
        Reservation thisReservation = reservationList.getSelectionModel().getSelectedItem();
        if (thisReservation == null) {
            return;
        }
        if (!thisReservation.isConfirmable()) {
            alertConfirmationImpossible();
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

    public ButtonType promptCancellation() {
        Alert cancel = new Alert(Alert.AlertType.CONFIRMATION);
        cancel.setTitle("Confirmation");
        cancel.setHeaderText(null);
        cancel.setContentText("Cancel this reservation?");
        Optional<ButtonType> answer = cancel.showAndWait();
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
        else {
            ButtonType answer = promptCancellation();
            if (answer.equals(ButtonType.OK)) {
                userReservations.removeIf(x -> x.getReservationId().equals(thisReservation.getReservationId()));
                loadFromObservableList(userReservations);
            }
        }

    }

    private void alertCancellationImpossible() {
        Alert denial = new Alert(Alert.AlertType.INFORMATION);
        denial.setTitle("Cancellation impossible");
        denial.setHeaderText(null);
        denial.setContentText("You cannot cancel this reservation any longer.");
        denial.showAndWait();
    }

    private void alertConfirmationImpossible() {
        Alert denial = new Alert(Alert.AlertType.INFORMATION);
        denial.setTitle("Confirmation impossible");
        denial.setHeaderText(null);
        denial.setContentText("You cannot confirm this reservation any longer.");
        denial.showAndWait();
    }
}


