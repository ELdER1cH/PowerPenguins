package pinguPinguEat.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import pinguPinguEat.ClientApplication;
import pinguPinguEat.logic.RestaurantLogic;
import pinguPinguEat.reservationModel.Reservation;
import pinguPinguEat.restaurants.CuisineType;
import pinguPinguEat.restaurants.PriceCategory;
import pinguPinguEat.restaurants.Restaurant;
import pinguPinguEat.user.Review;
import pinguPinguEat.user.User;

import java.io.IOException;


public class SceneController {
    public static final ObservableList<Restaurant> restaurants = FXCollections.observableArrayList();

    public static final ObservableList<Reservation> reservations = FXCollections.observableArrayList();
    private FXMLLoader loader;
  
    private FXMLLoader restaurantLoader;
    private RestaurantGroupController restaurantController;
    private FXMLLoader reservationLoader;

    private ReservationGroupController reservationController;
    private RestaurantReservationGroupController restaurantReservationController;


    @FXML
    public void initialize() throws IOException {
        //Import Restaurant Group
        restaurantLoader = new FXMLLoader(ClientApplication.class.getResource("RestaurantGroupView.fxml"));
        restaurantViewGroup = restaurantLoader.load();
        restaurantViewGroup.getChildren().get(0);
        restaurantController = restaurantLoader.getController();

        //Import Reservation Group
        reservationLoader = new FXMLLoader(ClientApplication.class.getResource("ReservationGroupView.fxml"));
        reservationViewGroup = reservationLoader.load();

        //Import Restaurants
        restaurants.addAll(RestaurantLogic.getAllRestaurants());
        restaurantList.setItems(restaurants);

        reservationController = loader.getController();
        reservationController.loadList();

        loader = new FXMLLoader(ClientApplication.class.getResource("RestaurantReservationGroupView.fxml"));
        restaurantReservationController = loader.getController();
        restaurantViewGroup = loader.load();
    }

    @FXML
    private Group mapViewGroup;
    @FXML
    private Group reservationViewGroup;
    @FXML
    private Group restaurantViewGroup;
    @FXML
    private Group restaurantReservationViewGroup;

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
        Restaurant restaurant = new Restaurant("TUM", CuisineType.GERMAN, PriceCategory.EXPENSIVE, "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.   \n" +
                "\n" +
                "Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Lorem ipsum dolor sit amet,Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.", null, "Mo: 8 - 18\nDi: 8 - 18\n", "www.google.com");
        restaurant.addReview(new Review(4, "Lorem Ipsum \n dolores", new User("Max", "Master")));
        restaurant.addImage("pinguPinguEat/img/tum.jpg");
        restaurant.addImage("pinguPinguEat/img/tum1.jpg");
        restaurantController.updateRestaurant(restaurant);
    }

    public void switchToRestaurantReservationView(ActionEvent event) throws IOException {
        switchToScene(restaurantReservationViewGroup);
    }

    private void switchToScene(Group viewGroup) throws IOException {
        viewStackPane.getChildren().clear();
        viewStackPane.setAlignment(Pos.TOP_LEFT);
        viewStackPane.getChildren().add(viewGroup);
    }

    @FXML // fx:id="loginButton"
    private Button loginButton; // Value injected by FXMLLoader
    //

    @FXML // fx:id="passWordField"
    private TextField passWordField; // Value injected by FXMLLoader

    @FXML // fx:id="registerButton"
    private Button registerButton; // Value injected by FXMLLoader

    @FXML // fx:id="restaurantList"
    private ListView<Restaurant> restaurantList; // Value injected by FXMLLoader

    @FXML // fx:id="reservationList"
    private ListView<Reservation> reservationList; // Value injected by FXMLLoader

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

    public TextField getSearchField() {
        return searchField;
    }

    public void setRestaurantList(ListView<Restaurant> restaurantList) {
        this.restaurantList = restaurantList;
    }
}
