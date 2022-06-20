package pinguPinguEat.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import pinguPinguEat.restaurants.Restaurant;

import java.io.File;
import java.io.IOException;

public class SceneController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    private static final String MAP_VIEW = "MapView.fxml";
    private static final String RESERVATION_VIEW = "ReservationView.fxml";
    private static final String RESTAURANT_VIEW = "RestaurantView.fxml";

    public void switchToMapView(ActionEvent event) throws IOException {
        switchToScene(event, MAP_VIEW);
    }

    public void switchToReservationView(ActionEvent event) throws IOException {
        switchToScene(event, RESERVATION_VIEW);

    }

    public void switchToRestaurantView(ActionEvent event) throws IOException {
        switchToScene(event, RESTAURANT_VIEW);
    }

    private void switchToScene(ActionEvent event, String SceneFileName) throws IOException {
        root = FXMLLoader.load(new File("src/client/resources/pinguPinguEat/" + SceneFileName).toURI().toURL());
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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
