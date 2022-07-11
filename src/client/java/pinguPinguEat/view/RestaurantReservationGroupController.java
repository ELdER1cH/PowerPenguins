package pinguPinguEat.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import pinguPinguEat.reservationModel.Reservation;
import pinguPinguEat.reservationModel.Table;

import java.io.IOException;

public class RestaurantReservationGroupController {
    private ObservableList<Table> freeTables = FXCollections.observableArrayList();
    @FXML // fx:id="restaurantReservationList"
    private ListView<Reservation> restaurantReservationList; // Value injected by FXMLLoader
    public RestaurantReservationGroupController() {
    }


    public void loadList() throws IOException {
        //freeTables.addAll(thisRestaurant.getFreeTables());
        //restaurantReservationList.setItems(freeTables);
    }


}
