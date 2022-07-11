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

import java.util.Optional;

public class ReservationGroupController {
    private ObservableList<Reservation> userReservations = FXCollections.observableArrayList();
    @FXML // fx:id="reservationList"
    private ListView<Reservation> reservationList; // Value injected by FXMLLoader

    public ReservationGroupController() {
        userReservations.addAll(MyReservationLogic.getAllReservations());
    };

    public void loadList() {
        reservationList.setItems(userReservations);
        setUpMouseClickActions();
    }

    private void setUpMouseClickActions() {
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
                    System.out.println(thisReservation.isConfirmed());
                    update(userReservations, thisReservation);
                }
                System.out.println("name: " + reservationList.getSelectionModel().getSelectedItems().toString());
            }
        });
    }

    private void update(ObservableList<Reservation> reservations, Reservation updatedReservation) {
        // this may seem overcomplicated but this was necessary for some reason
        reservations.removeIf(x -> x.getReservationId().equals(updatedReservation.getReservationId()));
        reservations.add(updatedReservation);
        reservationList.setItems(reservations);
    }
}
