package pinguPinguEat.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import pinguPinguEat.logic.RestaurantLogic;
import pinguPinguEat.restaurants.Restaurant;

import java.io.IOException;

public class SceneController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public static final ObservableList<Restaurant> restaurants = FXCollections.observableArrayList();

    @FXML
    private Group mapViewGroup;
    @FXML
    private Group reservationViewGroup;
    @FXML
    private Group restaurantViewGroup;

    @FXML
    private StackPane viewStackPane;

    public void switchToMapView(ActionEvent event) throws IOException {
        switchToScene(event, mapViewGroup);
    }

    public void switchToReservationView(ActionEvent event) throws IOException {
        switchToScene(event, reservationViewGroup);

    }

    public void switchToRestaurantView(ActionEvent event) throws IOException {
        switchToScene(event, restaurantViewGroup);
    }

    private void switchToScene(ActionEvent event, Group viewGroup) throws IOException {
        viewStackPane.getChildren().clear();
        viewStackPane.getChildren().add(viewGroup);
    }


    public void loadRestaurants() {
        restaurants.addAll(RestaurantLogic.getAllRestaurants());
        restaurantList.setItems(restaurants);
    }

    @FXML // fx:id="HelloSign"
    private Label HelloSign; // Value injected by FXMLLoader

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