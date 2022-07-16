package pinguPinguEat.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import pinguPinguEat.ClientApplication;
import pinguPinguEat.logic.RestaurantLogic;
import pinguPinguEat.logic.SearchFilter;
import pinguPinguEat.reservationModel.Reservation;
import pinguPinguEat.restaurants.CuisineType;
import pinguPinguEat.restaurants.PriceCategory;
import pinguPinguEat.restaurants.Restaurant;
import pinguPinguEat.user.Review;
import pinguPinguEat.user.User;

import java.io.IOException;
import java.util.ArrayList;


public class SceneController {
    public static final ObservableList<Restaurant> restaurants = FXCollections.observableArrayList();

    public static final ObservableList<Reservation> reservations = FXCollections.observableArrayList();
    private FXMLLoader restaurantReservationLoader;
  
    private FXMLLoader restaurantLoader;
    private RestaurantGroupController restaurantController;
    private FXMLLoader reservationLoader;

    private ReservationGroupController reservationController;
    private RestaurantReservationGroupController restaurantReservationController;

    private SearchFilter searchFilter;

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

        reservationController = reservationLoader.getController();
        reservationController.loadList();

        restaurantReservationLoader = new FXMLLoader(ClientApplication.class.getResource("RestaurantReservationGroupView.fxml"));
        restaurantReservationController = restaurantReservationLoader.getController();
        restaurantReservationViewGroup = restaurantReservationLoader.load();
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

    public SceneController() {
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
        //???
    }

    @FXML
    void registerAction(ActionEvent event) {
        // nichts passiert
    }

    // Search Button pressed
    @FXML
    void searchAction(ActionEvent event) {
        ArrayList<Restaurant> allRestaurantsToFilter = (ArrayList<Restaurant>) RestaurantLogic.getAllRestaurants();
        for (Restaurant r : allRestaurantsToFilter) {
            restaurantController.updateRestaurant(r);
            // inconsistent with filter
            if ((r.getCuisineType() == CuisineType.GERMAN) !=
                    searchFilter.isSelectedCuisineTypeGerman() ||
                    (r.getCuisineType() == CuisineType.ITALIAN) != searchFilter.isSelectedCuisineTypeItalian() ||
                    (r.getCuisineType() == CuisineType.CHINESE) != searchFilter.isSelectedCuisineTypeChinese() ||
                    (r.getPriceCategory() == PriceCategory.INEXPENSIVE) != searchFilter.isSelectedPriceInexpensive() ||
                    (r.getPriceCategory() == PriceCategory.MODERATE) != searchFilter.isSelectedPriceModerate() ||
                    (r.getPriceCategory() == PriceCategory.EXPENSIVE) != searchFilter.isSelectedPriceExpensive() ||
                    (r.getPriceCategory() == PriceCategory.VERY_EXPENSIVE) != searchFilter.isSelectedPriceVeryExpensive()) {
                allRestaurantsToFilter.remove(r);
            }
        }
        restaurants.removeAll();
        restaurants.addAll(allRestaurantsToFilter);
    }

    // Filter Button pressed
    void filterAction(ActionEvent event) {
        filterButton.setOnAction(e -> showFilterDialog());
    }

    // Dialog mit CheckBoxen zum Filtern bei der Suche nach Restaurants
    public void showFilterDialog() {
        Dialog dialog = new Dialog<>();
        dialog.setTitle("Search filter");
        dialog.setHeaderText("Please select your search preferences:");

        // Dialog Komponenten: checkBoxes schon selected
        Label labelCuisine = new Label("Cusine Type");
        CheckBox checkBoxCuisineGerman = new CheckBox("German");
        checkBoxCuisineGerman.setSelected(true);
        CheckBox checkBoxCuisineItalian = new CheckBox("Italian");
        checkBoxCuisineItalian.setSelected(true);
        CheckBox checkBoxCuisineChinese = new CheckBox("Chinese");
        checkBoxCuisineChinese.setSelected(true);
        Label labelPrice = new Label("Price Category");
        CheckBox checkBoxPriceInexpensive = new CheckBox("Inexpensive");
        checkBoxPriceInexpensive.setSelected(true);
        CheckBox checkBoxPriceModerate = new CheckBox("Moderate");
        checkBoxPriceModerate.setSelected(true);
        CheckBox checkBoxPriceExpensive = new CheckBox("Expensive");
        checkBoxPriceExpensive.setSelected(true);
        CheckBox checkBoxPriceVeryExpensive = new CheckBox("Very Expensive");
        checkBoxPriceVeryExpensive.setSelected(true);
        Button resetButton = new Button("reset");
        VBox vBox = new VBox(labelCuisine, checkBoxCuisineGerman, checkBoxCuisineItalian, checkBoxCuisineChinese,
                labelPrice, checkBoxPriceInexpensive, checkBoxPriceModerate, checkBoxPriceExpensive, checkBoxPriceVeryExpensive, resetButton);

        dialog.getDialogPane().setContent(vBox);

        // Dialog Buttons
        ButtonType buttonTypeOk = new ButtonType("Done", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().add(buttonTypeOk);
        Button okButton = (Button) dialog.getDialogPane().lookupButton(buttonTypeOk);

        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        dialog.getDialogPane().getButtonTypes().add(buttonTypeCancel);
        Button cancelButton = (Button) dialog.getDialogPane().lookupButton(buttonTypeCancel);

        dialog.show();

        // Ok Button action
        okButton.setOnAction(e -> {
            if (checkBoxCuisineGerman.isSelected()) {
                searchFilter.selectCuisine(CuisineType.GERMAN);
            }
            if (checkBoxCuisineItalian.isSelected()) {
                searchFilter.selectCuisine(CuisineType.ITALIAN);
            }
            if (checkBoxCuisineChinese.isSelected()) {
                searchFilter.selectCuisine(CuisineType.CHINESE);
            }
            if (checkBoxPriceInexpensive.isSelected()) {
                searchFilter.selectPriceCategory(PriceCategory.INEXPENSIVE);
            }
            if (checkBoxPriceModerate.isSelected()) {
                searchFilter.selectPriceCategory(PriceCategory.MODERATE);
            }
            if (checkBoxPriceExpensive.isSelected()) {
                searchFilter.selectPriceCategory(PriceCategory.EXPENSIVE);
            }
            if (checkBoxPriceVeryExpensive.isSelected()) {
                searchFilter.selectPriceCategory(PriceCategory.VERY_EXPENSIVE);
            }
            dialog.close();
        });

        // Cancel Button Action
        cancelButton.setOnAction(e -> {
            dialog.close();
        });

        resetButton.setOnAction(e -> {
            checkBoxCuisineGerman.setSelected(true);
            checkBoxCuisineItalian.setSelected(true);
            checkBoxCuisineChinese.setSelected(true);
            checkBoxPriceInexpensive.setSelected(true);
            checkBoxPriceModerate.setSelected(true);
            checkBoxPriceExpensive.setSelected(true);
            checkBoxPriceVeryExpensive.setSelected(true);
            searchFilter.resetFilter();
        });

    }


    public TextField getSearchField() {
        return searchField;
    }

    public void setRestaurantList(ListView<Restaurant> restaurantList) {
        this.restaurantList = restaurantList;
    }
}
