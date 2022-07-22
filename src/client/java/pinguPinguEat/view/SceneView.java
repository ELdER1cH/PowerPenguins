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
import pinguPinguEat.logic.SearchFilter;
import pinguPinguEat.reservationElement.Reservation;
import pinguPinguEat.restaurantElement.CuisineType;
import pinguPinguEat.restaurantElement.PriceCategory;
import pinguPinguEat.restaurantElement.Restaurant;
import pinguPinguEat.userElement.Review;
import pinguPinguEat.userElement.User;

import java.io.IOException;
import java.util.ArrayList;


public class SceneView {
    public static final ObservableList<Restaurant> restaurants = FXCollections.observableArrayList();


    private FXMLLoader mapLoader;
    private  MapGroupView mapGroupView;

    public static final ObservableList<Reservation> reservations = FXCollections.observableArrayList();
    private FXMLLoader restaurantReservationLoader;

    private FXMLLoader restaurantLoader;
    private RestaurantGroupView restaurantGroupView;
    private FXMLLoader reservationLoader;

    private ReservationGroupView reservationGroupView;
    private RestaurantReservationGroupView restaurantReservationGroupView;

    private RestaurantLogic restaurantLogic;

    private final SearchFilter searchFilter;


    @FXML
    public void initialize() throws IOException {
        //Import Map Group
        mapLoader = new FXMLLoader(ClientApplication.class.getResource("MapGroupView.fxml"));
        mapViewGroup = mapLoader.load();
        mapGroupView = mapLoader.getController();

        //Import Restaurant Group

        restaurantLoader = new FXMLLoader(ClientApplication.class.getResource("RestaurantGroupView.fxml"));
        restaurantViewGroup = restaurantLoader.load();
        restaurantGroupView = restaurantLoader.getController();
        restaurantGroupView.setSceneView(this);

        //Import Reservation Group
        reservationLoader = new FXMLLoader(ClientApplication.class.getResource("ReservationGroupView.fxml"));
        reservationViewGroup = reservationLoader.load();

        //Import Restaurants
        //restaurants.addAll(RestaurantLogic.getAllRestaurants());
        //restaurantList.setItems(restaurants);


        reservationGroupView = reservationLoader.getController();
        reservationGroupView.loadList();

        restaurantReservationLoader = new FXMLLoader(ClientApplication.class.getResource("RestaurantReservationGroupView.fxml"));
        restaurantReservationViewGroup = restaurantReservationLoader.load();
        restaurantReservationGroupView = restaurantReservationLoader.getController();

        restaurantLogic = new RestaurantLogic();
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

    @FXML // fx:id= ???
    private Button filterButton;


    public void switchToMapView(ActionEvent event) throws IOException {
        switchToScene(mapViewGroup);
        mapGroupView.setRestaurants(restaurants);
    }

    public void switchToReservationView(ActionEvent event) throws IOException {
        switchToScene(reservationViewGroup);
    }

    public void switchToRestaurantView(ActionEvent event) throws IOException {
        switchToScene(restaurantViewGroup);
        Restaurant restaurant = new Restaurant("TUM", "address", CuisineType.GERMAN, PriceCategory.EXPENSIVE, "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.   \n" +
                "\n" +
                "Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Lorem ipsum dolor sit amet,Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.", null, "Mo: 8 - 18\nDi: 8 - 18\n", "www.google.com", 05);
        restaurant.addReview(new Review(4, "Lorem Ipsum \n dolores", new User("Max", "Master")));
        restaurant.addImage("pinguPinguEat/img/tum.jpg");
        restaurant.addImage("pinguPinguEat/img/tum1.jpg");
        restaurantGroupView.updateRestaurant(restaurant);
    }

    public void switchToRestaurantReservationView(ActionEvent event) throws IOException {
        switchToScene(restaurantReservationViewGroup);
        Restaurant restaurant = new Restaurant("TUM", "address", CuisineType.GERMAN, PriceCategory.EXPENSIVE, "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.   \n" +
                "\n" +
                "Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Lorem ipsum dolor sit amet,Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.", null, "Mo: 8 - 18\nDi: 8 - 18\n", "www.google.com", 05);
        restaurant.addReview(new Review(4, "Lorem Ipsum \n dolores", new User("Max", "Master")));
        restaurant.addImage("pinguPinguEat/img/tum.jpg");
        restaurant.addImage("pinguPinguEat/img/tum1.jpg");
        restaurantGroupView.updateRestaurant(restaurant);
    }

    public void switchToRestaurantReservationView(Restaurant restaurant, ActionEvent event) throws IOException {
        switchToScene(restaurantReservationViewGroup);
        restaurantReservationGroupView.setRestaurant(restaurant);
        restaurantReservationGroupView.updateView();
    }

    public void switchToSelectedRestaurant() throws IOException {
        switchToRestaurantView(null);
        restaurantGroupView.updateRestaurant(restaurantList.getSelectionModel().getSelectedItem());

    }

    private void switchToScene(Group viewGroup) throws IOException {
        viewStackPane.getChildren().clear();
        viewStackPane.setAlignment(Pos.TOP_LEFT);
        viewStackPane.getChildren().add(viewGroup);
    }

    @FXML // fx:id="loginButton"
    private Button loginButton; // Value injected by FXMLLoader
    //

    public SceneView() {
        searchFilter = new SearchFilter();
    }


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
        // nichts passiert

    }

    @FXML
    void onHelloButtonClick(ActionEvent event) {

    }

    @FXML
    void registerAction(ActionEvent event) {

        // nichts passiert

    }

    @FXML
    void searchAction(ActionEvent event) {
        // Search Button pressed
        ArrayList<Restaurant> allRestaurantsToFilter = (ArrayList<Restaurant>) RestaurantLogic.getAllRestaurants();
        ArrayList<Restaurant> allRestaurantsToRemove = new ArrayList<>();

        for (Restaurant r : allRestaurantsToFilter) {
            restaurantGroupView.updateRestaurant(r);
            // inconsistent with filter
            if ((r.getCuisineType() == CuisineType.GERMAN) && !searchFilter.isSelectedCuisineTypeGerman() ||
                    (r.getCuisineType() == CuisineType.ITALIAN) && !searchFilter.isSelectedCuisineTypeItalian() ||
                    (r.getCuisineType() == CuisineType.CHINESE) && !searchFilter.isSelectedCuisineTypeChinese() ||
                    (r.getPriceCategory() == PriceCategory.INEXPENSIVE) && !searchFilter.isSelectedPriceInexpensive() ||
                    (r.getPriceCategory() == PriceCategory.MODERATE) && !searchFilter.isSelectedPriceModerate() ||
                    (r.getPriceCategory() == PriceCategory.EXPENSIVE) && !searchFilter.isSelectedPriceExpensive() ||
                    (r.getPriceCategory() == PriceCategory.VERY_EXPENSIVE) && !searchFilter.isSelectedPriceVeryExpensive() ||
                    ((int) (r.getAverageRating() + 0.5) < searchFilter.getSelectedRating())) {
                allRestaurantsToRemove.add(r);
            }
        }
        allRestaurantsToFilter.removeAll(allRestaurantsToRemove);

        String query = searchField.getText();
        String[] queryWords = query.split(" ");
        ArrayList<Restaurant> allRestaurantsQuery = new ArrayList<>();
        for (String queryWord : queryWords) {
            for (Restaurant r : allRestaurantsToFilter) {
                if (r.getName().toLowerCase().contains(queryWord.toLowerCase()) || r.getDescription().toLowerCase().contains(queryWord.toLowerCase())) {
                    allRestaurantsQuery.add(r);
                }
            }
        }

        restaurantList.getItems().clear();
        restaurants.addAll(/*RestaurantLogic.getAllRestaurants()*/allRestaurantsQuery);
        restaurantList.setItems(restaurants);
    }
    // Filter Button pressed
    @FXML
    void filterAction(ActionEvent event) {
        restaurantLogic.showFilterDialog();
    }



    void listViewClickedToSeeDetails(ActionEvent event) {
        restaurantLogic.showRestaurantDetailsByClickingIt(event);
    }


    public TextField getSearchField() {
        return searchField;
    }

    public ListView<Restaurant> getRestaurantList() {
        return restaurantList;
    }

    public ObservableList<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurantList(ListView<Restaurant> restaurantList) {
        this.restaurantList = restaurantList;
    }
}
