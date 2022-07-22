package pinguPinguEat.logic;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import pinguPinguEat.controller.RestaurantController;
import pinguPinguEat.reservationElement.ReservationSystem;
import pinguPinguEat.restaurantElement.CuisineType;
import pinguPinguEat.restaurantElement.PriceCategory;
import pinguPinguEat.restaurantElement.Restaurant;
import pinguPinguEat.userElement.Review;
import pinguPinguEat.userElement.User;
import pinguPinguEat.view.MapGroupView;
import pinguPinguEat.view.SceneView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class RestaurantLogic {
    private final ObservableList<Restaurant> restaurantObservableList;
    private final HashMap<UUID, Restaurant> searchResult;
    private final SceneView sceneView;
    private final RestaurantController restaurantController;

    private final MapGroupView mapGroupView;

    public RestaurantLogic() {
        this.restaurantController = new RestaurantController();
        this.sceneView = new SceneView();
        this.restaurantObservableList = FXCollections.observableArrayList();
        this.searchResult = new HashMap<>();
        this.mapGroupView = new MapGroupView();

// !!!
//        restaurantController.getAllRestaurants(this::setRestaurant);
    }

    // "on action" method for "search" button
    //    FR1: Search for restaurants: The user can search for restaurants
    //    on a list and on a map that displays up to 50 restaurants.
    public void searchRestuarant(ActionEvent event) {
        String searchCondition = sceneView.getSearchField().getText();
        // use String.contains() for the name and cuisineType of restaurants.

        mapGroupView.showRestaurantsOnMap();
    }

    //    click to see the details of restaurants
    //    FR2: See restaurants details: The user can see pictures,
    //    ratings and comments of the restaurant as well as opening times and a link to the website.
    public void showRestaurantDetailsByClickingIt(ActionEvent event) {
//    click on ListView

    }

    //  "on action" method for filter combobox --> choose filter conditions
//    FR3: Filter search results: He can filter the results by the restaurant type, the prize category,
//    by distance around a certain location, by the average rating
//    and by free time slots for reservations for specified dates and number of visitors.
    public void filterRestaurant(ActionEvent event) {
        updateTableViewAccordingToComboBox();
    }


    public static List<Restaurant> getAllRestaurants() {
        List<Restaurant> returnValue = new ArrayList<>();
        Restaurant test1 = new Restaurant("Test", "address", CuisineType.GERMAN, PriceCategory.INEXPENSIVE, "Test 1", new ReservationSystem(0, 0), "Mo: 8 - 18", "www.google.com", 06);
        Restaurant test2 = new Restaurant("Lorem Ipsum", "address", CuisineType.GERMAN, PriceCategory.INEXPENSIVE, "Test 2", new ReservationSystem(0, 0), "Mo: 8 - 18", "www.google.com", 07);
        test1.addReview(new Review(5, "review test 1", new User("Hugh", "Janus")));
        test2.addReview(new Review(5, "review test 2", new User("Patricia", "Table")));
        test2.addReview(new Review(5, "amazing place!", new User("Alex", "Corn")));
        returnValue.add(test1);
        returnValue.add(test2);
        return returnValue;
    }


    private void initiateComboBoxForFilter(ComboBox comboBox) {
        ArrayList<String> filterOptions = new ArrayList<>();
        filterOptions.add("Restaurant Type");
        filterOptions.add("Price Category");
        filterOptions.add("Certain Location");
        filterOptions.add("Average Rating");
        filterOptions.add("Free Time Slots");
        filterOptions.add("Number of Visitors");
    }


    //    ???
    // "on action" method for "sort" combo box, attributes and the orders
    // according to different attributes and the orders, ascending or descending.
    public void sortRestaurat(ActionEvent event) {
//     restaurantController.getAllRestaurants()(sortingOptions, this::setRestaurant));
    }


    private void setRestaurant(List<Restaurant> restaurant) {
        Platform.runLater(() -> restaurantObservableList.setAll(restaurant));
    }

    public void updateTableViewAccordingToComboBox() {
//         restaurant type, prize category,free time slots,number of visitors
        FilteredList<Restaurant> filteredList = new FilteredList<>(restaurantObservableList, i -> true);

        ComboBox<String> filterOption = new ComboBox();
        initiateComboBoxForFilter(filterOption);

        filterOption.setEditable(true);

        // Add a listener to the textProperty of the combobox editor. The
        // listener will simply filter the list every time the input is changed
        // as long as the user hasn't selected an item in the list.
        filterOption.getEditor().textProperty().addListener((obs, oldValue, newValue) -> {
            final TextField editor = filterOption.getEditor();

            final String selected = filterOption.getSelectionModel().getSelectedItem();

            // This needs run on the GUI thread to avoid the error described
            // here: https://bugs.openjdk.java.net/browse/JDK-8081700.
            Platform.runLater(() -> {

                // If the no item in the list is selected or the selected item
                // isn't equal to the current input, we refilter the list.
                if (selected == null || !selected.equals(editor.getText())) {

                    if (selected.equals("Restaurant Type")) {
                        filteredList.setPredicate(Restaurant -> {
                            // We return true for any items that meet the condition
                            return Restaurant.getCuisineType().equals(newValue.toUpperCase());
                        });
                    } else if (selected.equals("Price Category")) {
//                        Todo
                    }
                }
            });
        });


        TableView<Restaurant> table = new TableView(filteredList);
//        !!!
//        sceneView.setRestaurantList(table);
    }
}
