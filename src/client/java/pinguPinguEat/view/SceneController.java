package pinguPinguEat.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import pinguPinguEat.ClientApplication;
import pinguPinguEat.logic.RestaurantLogic;
import pinguPinguEat.restaurants.Restaurant;

import java.io.IOException;


public class SceneController {
    public static final ObservableList<Restaurant> restaurants = FXCollections.observableArrayList();
    private FXMLLoader loader;

    @FXML
    public void initialize() throws IOException {
        //Import Restaurant Group
        loader = new FXMLLoader(ClientApplication.class.getResource("RestaurantGroupView.fxml"));
        restaurantViewGroup = loader.load();

        //Import Reservation Group
        loader = new FXMLLoader(ClientApplication.class.getResource("ReservationGroupView.fxml"));
        reservationViewGroup = loader.load();

        //Import Restaurants
        restaurants.addAll(RestaurantLogic.getAllRestaurants());
        restaurantList.setItems(restaurants);
    }

    @FXML
    private Group mapViewGroup;
    @FXML
    private Group reservationViewGroup;
    @FXML
    private Group restaurantViewGroup;

    @FXML
    private StackPane viewStackPane;


    public void switchToMapView(ActionEvent event) throws IOException {
        switchToScene(mapViewGroup);
    }

    public void switchToReservationView(ActionEvent event) throws IOException {
        switchToScene(reservationViewGroup);

    }

    public void switchToRestaurantView(ActionEvent event) throws IOException {
        switchToScene(restaurantViewGroup);
    }

    private void switchToScene(Group viewGroup) throws IOException {
        viewStackPane.getChildren().clear();
        viewStackPane.getChildren().add(viewGroup);
    }

    @FXML // fx:id="loginButton"
    private Button loginButton; // Value injected by FXMLLoader

    @FXML // fx:id="passWordField"
    private TextField passWordField; // Value injected by FXMLLoader

    @FXML // fx:id="registerButton"
    private Button registerButton; // Value injected by FXMLLoader

    @FXML // fx:id="restaurantList"
    private ListView<Restaurant> restaurantList; // Value injected by FXMLLoader

    @FXML // fx:id="searchButton"
    private Button searchButton; // Value injected by FXMLLoader

    @FXML // fx:id="searchField"
    private TextField searchField; // Value injected by FXMLLoader

    @FXML // fx:id="type1"
    private ImageView type1; // Value injected by FXMLLoader

    @FXML // fx:id="userNameField"
    private TextField userNameField; // Value injected by FXMLLoader

    @FXML
    void loginAction(ActionEvent event) {

    }

    @FXML
    void onHelloButtonClick(ActionEvent event) {

    }

    @FXML
    void registerAction(ActionEvent event) {

    }

    @FXML
    void searchAction(ActionEvent event) {

    }
}
