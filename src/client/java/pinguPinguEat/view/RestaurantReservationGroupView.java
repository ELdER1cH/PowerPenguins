package pinguPinguEat.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import pinguPinguEat.reservationElement.Reservation;
import pinguPinguEat.reservationElement.Table;
import pinguPinguEat.reservationElement.TimeSlot;
import pinguPinguEat.restaurantElement.Restaurant;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class RestaurantReservationGroupView {
    private ObservableList<Table> freeTables = FXCollections.observableArrayList();
    private Restaurant currentRestaurant;
    @FXML // fx:id="restaurantReservationList"
    private ListView<Table> restaurantReservationList; // Value injected by FXMLLoader

    @FXML // fx:id="datePicker"
    private DatePicker datePicker;

    @FXML // fx:id="timeChoiceBox"
    private ChoiceBox timeChoiceBox;

    @FXML
    private TextField peopleNumberPicker;

    @FXML
    private Label title;

    @FXML
    public void initialize() {
        ObservableList<String> times = FXCollections.observableArrayList();
        times.addAll("18:00 Uhr", "19:00 Uhr", "20:00 Uhr");
        timeChoiceBox.setItems(times);
    }

    public RestaurantReservationGroupView() {

    }

    public void setRestaurant(Restaurant restaurant) {
        this.currentRestaurant = restaurant;
    }

    public void updateViewBtn() {
        if (timeChoiceBox.getValue() == null || datePicker.getValue() == null
                || peopleNumberPicker.getText() == null || peopleNumberPicker.getText() == "") {
            lackingInputAlert();
            return;
        }

        updateView();
    }

    public void updateView() {
        restaurantReservationList.getItems().clear();
        TimeSlot timeSlot = getTimeSlot();

        if (currentRestaurant.getReservationSystem() != null) {
            freeTables.addAll(currentRestaurant.getReservationSystem().getFreeTables(timeSlot));
        }


        freeTables.add(new Table(23, 3));


        freeTables = filterNumberOfSeats(freeTables);



        if (freeTables.isEmpty()) {
            noTablesAlert();
        }
        restaurantReservationList.setItems(freeTables);
    }

    public void reserve() {
        if (currentRestaurant.getReservationSystem() == null) {
            throw new NullPointerException("This restaurant doesn't have a reservation system.");
        }
        Table table = restaurantReservationList.getSelectionModel().getSelectedItem();
        Reservation newReservation = new Reservation(getTimeSlot(), table, currentRestaurant);
        if (!currentRestaurant.getReservationSystem().addReservation(newReservation)) {
            failedReservationAlert();
        }
        else {
            reservationSuccessfulAlert();
        }
    }


    //    FR4: Reserve table: A user can see the times when he can reserve a table in the chosen restaurant.
    private TimeSlot getTimeSlot() {
        LocalTime timeSlotTime;
        timeSlotTime = switch(timeChoiceBox.getValue().toString()) {
            case "18:00 Uhr" -> LocalTime.of(18, 00);
            case "19:00 Uhr" -> LocalTime.of(19, 00);
            case "20:00 Uhr" -> LocalTime.of(20, 00);
            default -> LocalTime.of(00, 00);
        };

        LocalDate timeSlotDate = datePicker.getValue();

        return new TimeSlot(LocalDateTime.of(timeSlotDate, timeSlotTime));
    }

    //TODO catch exceptions

    //    After clicking on the time, the user sees an overview of all tables in the restaurant.
    private ObservableList<Table> filterNumberOfSeats(ObservableList<Table> tables) {
        int numberRequested = Integer.valueOf(peopleNumberPicker.getText());
        tables.removeIf(x -> x.getNumberOfSeats() < numberRequested);
        return tables;
    }

    private void lackingInputAlert() {
        Alert noTables = new Alert(Alert.AlertType.ERROR);
        noTables.setTitle("Lacking Input");
        noTables.setHeaderText(null);
        noTables.setContentText("Please fill all the input fields and try again.");
        noTables.showAndWait();
    }

    private void noTablesAlert() {
        Alert noTables = new Alert(Alert.AlertType.INFORMATION);
        noTables.setTitle("No Tables Available");
        noTables.setHeaderText(null);
        noTables.setContentText("There are no free tables that meet the selected criteria.");
        noTables.showAndWait();
    }

    private void failedReservationAlert() {
        Alert failedRes = new Alert(Alert.AlertType.ERROR);
        failedRes.setTitle("Error");
        failedRes.setHeaderText(null);
        failedRes.setContentText("Something went wrong with the reservation.\n"+
                "Please refresh and try again.");
        failedRes.showAndWait();
    }

    private void reservationSuccessfulAlert() {
        Alert success = new Alert(Alert.AlertType.INFORMATION);
        success.setTitle("Reservation Made");
        success.setHeaderText(null);
        success.setContentText("Your reservation was successful.");
        success.showAndWait();
    }
}
