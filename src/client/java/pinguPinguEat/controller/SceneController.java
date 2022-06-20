package pinguPinguEat.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
        root = FXMLLoader.load(getClass().getResource(SceneFileName));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
