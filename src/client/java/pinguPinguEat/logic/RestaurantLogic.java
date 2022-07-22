package pinguPinguEat.logic;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import pinguPinguEat.controller.RestaurantController;
import pinguPinguEat.reservationElement.ReservationSystem;
import pinguPinguEat.restaurantElement.CuisineType;
import pinguPinguEat.restaurantElement.PriceCategory;
import pinguPinguEat.restaurantElement.Restaurant;
import pinguPinguEat.userElement.Review;
import pinguPinguEat.userElement.User;
import pinguPinguEat.view.RestaurantGroupView;
import pinguPinguEat.view.SceneView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class RestaurantLogic {
    private final ObservableList<Restaurant> restaurantObservableList;
    private final HashMap<UUID, Restaurant> searchResult;
    private final SceneView sceneView;

    private final RestaurantGroupView restaurantGroupView;
    private final SearchFilter searchFilter;
    private final RestaurantController restaurantController;

    public RestaurantLogic() {
        this.restaurantController = new RestaurantController();
        this.sceneView = new SceneView();
        this.restaurantObservableList = FXCollections.observableArrayList();
        this.searchResult = new HashMap<>();
        restaurantGroupView = new RestaurantGroupView();
        searchFilter = new SearchFilter();
// !!!
//        restaurantController.getAllRestaurants(this::setRestaurant);
    }

    public static List<Restaurant> getAllRestaurants() {
        List<Restaurant> returnValue = new ArrayList<>();
        Restaurant test1 = new Restaurant("Test", "Adresse", CuisineType.GERMAN, PriceCategory.INEXPENSIVE, "Test 1", new ReservationSystem(0, 0), "Mo: 8 - 18", "www.google.com", 06);
        Restaurant test2 = new Restaurant("Lorem Ipsum", "Sternstraße 7", CuisineType.GERMAN, PriceCategory.INEXPENSIVE, "Ramen", new ReservationSystem(0, 0), "Mo: 8 - 18", "www.google.com", 07);
        Restaurant test3 = new Restaurant("PinguEat", "Arcisstraße 23", CuisineType.GERMAN, PriceCategory.INEXPENSIVE, "eat fish stay fit", new ReservationSystem(0, 0), "Mo: 8 - 18", "www.google.com", 06);
        Restaurant test4 = new Restaurant("Pizza", "Boltzmannstraße 42", CuisineType.GERMAN, PriceCategory.INEXPENSIVE, "Lecker", new ReservationSystem(0, 0), "Mo: 8 - 18", "www.google.com", 07);
        Restaurant test5 = new Restaurant("Essen", "Im Paradies 12", CuisineType.GERMAN, PriceCategory.INEXPENSIVE, "Hier gibt es Essen zum essen", new ReservationSystem(0, 0), "Mo: 8 - 18", "www.google.com", 06);
        Restaurant test6 = new Restaurant("Kochstube", "Am See 24", CuisineType.GERMAN, PriceCategory.INEXPENSIVE, "Nudelsalat und vieles mehr", new ReservationSystem(0, 0), "Mo: 8 - 18", "www.google.com", 07);
        Restaurant test7 = new Restaurant("PinguRestaurant", "Pinguinallee 4", CuisineType.GERMAN, PriceCategory.INEXPENSIVE, "Wir servieren nur frische Speisen", new ReservationSystem(0, 0), "Mo: 8 - 18", "www.google.com", 06);

        test1.addReview(new Review(5, "review test 1", new User("Hugh", "Janus")));
        test2.addReview(new Review(5, "review test 2", new User("Patricia", "Table")));
        test2.addReview(new Review(5, "amazing place!", new User("Alex", "Corn")));
        test7.addReview(new Review(1, "das Essen ist nicht frisch und es gibt Kakerlaken im Restaurant. NIE WIEDER!", new User("Philipp", "angryCustomer21")));
        test7.addReview(new Review(5, "Tolle unterkunft und viel Essen", new User("Kakerlake", "immortal71")));
        test2.addReview(new Review(4, "I like the chairs", new User("Matthew", "mattie")));
        test7.addReview(new Review(2, "no", new User("Nana", "nunu")));

        test5.addReview(new Review(4, "Super toll :)", new User("Anne", "anne242")));
        test6.addReview(new Review(3, "ok", new User("Alex", "Corn")));
        test6.addReview(new Review(2, "zu lange Wartezeiten, bin eingeschlafen", new User("Eleanore", "ele123")));
        test3.addReview(new Review(1, "very rude servants", new User("Melanie", "mel3636")));
        test1.addReview(new Review(4, "pretty good", new User("Steph", "amazingPerson")));


        returnValue.add(test1);
        returnValue.add(test2);
        returnValue.add(test3);
        returnValue.add(test4);
        returnValue.add(test5);
        returnValue.add(test6);
        returnValue.add(test7);
        return returnValue;
    }

    //    click to see the details of restaurants
    //    FR2: See restaurants details: The user can see pictures,
    //    ratings and comments of the restaurant as well as opening times and a link to the website.
    public void showRestaurantDetailsByClickingIt(ActionEvent event) {
//    click on Map

//    click on TableView

    }

    //  "on action" method for filter combobox --> choose filter conditions
    public void filterRestaurant(ActionEvent event) {
        showFilterDialog();
    }

    // "on action" method for "search" button
    //    FR1: Search for restaurants: The user can search for restaurants
    //    on a list and on a map that displays up to 50 restaurants.
    public void searchRestaurant(ActionEvent event) {
        // Search Button pressed
        ArrayList<Restaurant> allRestaurantsToFilter = (ArrayList<Restaurant>) RestaurantLogic.getAllRestaurants();

        for (Restaurant r : allRestaurantsToFilter) {
            restaurantGroupView.updateRestaurant(r);
            // inconsistent with filter
            if ((r.getCuisineType() == CuisineType.GERMAN) !=
                    searchFilter.isSelectedCuisineTypeGerman() ||
                    (r.getCuisineType() == CuisineType.ITALIAN) != searchFilter.isSelectedCuisineTypeItalian() ||
                    (r.getCuisineType() == CuisineType.CHINESE) != searchFilter.isSelectedCuisineTypeChinese() ||
                    (r.getPriceCategory() == PriceCategory.INEXPENSIVE) != searchFilter.isSelectedPriceInexpensive() ||
                    (r.getPriceCategory() == PriceCategory.MODERATE) != searchFilter.isSelectedPriceModerate() ||
                    (r.getPriceCategory() == PriceCategory.EXPENSIVE) != searchFilter.isSelectedPriceExpensive() ||
                    (r.getPriceCategory() == PriceCategory.VERY_EXPENSIVE) != searchFilter.isSelectedPriceVeryExpensive() ||
                    ((int) (r.getAverageRating() + 0.5) < searchFilter.getSelectedRating())) {
                allRestaurantsToFilter.remove(r);
            }
        }
        String query = (String) sceneView.getSearchField().getCharacters();
        String[] queryWords = query.split(" ");
        for (String queryWord : queryWords) {
            for (Restaurant r : allRestaurantsToFilter) {
                if (!r.getName().toLowerCase().contains(queryWord.toLowerCase()) && !r.getDescription().toLowerCase().contains(queryWord.toLowerCase())) {
                    allRestaurantsToFilter.remove(r);
                }
            }
        }

        sceneView.getRestaurants().removeAll();
        sceneView.getRestaurants().addAll(allRestaurantsToFilter);
        sceneView.getRestaurantList().getItems().removeAll();
        sceneView.getRestaurantList().getItems().setAll(sceneView.getRestaurants());
        sceneView.getRestaurantList().refresh();

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

    private void setRestaurant(List<Restaurant> restaurant) {
        Platform.runLater(() -> restaurantObservableList.setAll(restaurant));
    }
    // Dialog mit CheckBoxen/Spinner zum Filtern bei der Suche nach Restaurants (Suche nach Namen und Beschreibung)
    public void showFilterDialog() {
        Dialog dialog = new Dialog<>();
        dialog.setTitle("Search filter");
        dialog.setHeaderText("Please select your search preferences:");

        // Dialog Komponenten: checkBoxes schon selected
        Label labelCuisine = new Label("Cusine Type");
        CheckBox checkBoxCuisineGerman = new CheckBox("German");
        checkBoxCuisineGerman.setSelected(searchFilter.isSelectedCuisineTypeGerman());
        CheckBox checkBoxCuisineItalian = new CheckBox("Italian");
        checkBoxCuisineItalian.setSelected(searchFilter.isSelectedCuisineTypeItalian());
        CheckBox checkBoxCuisineChinese = new CheckBox("Chinese");
        checkBoxCuisineChinese.setSelected(searchFilter.isSelectedCuisineTypeChinese());
        Label labelPrice = new Label("Price Category");
        CheckBox checkBoxPriceInexpensive = new CheckBox("Inexpensive");
        checkBoxPriceInexpensive.setSelected(searchFilter.isSelectedPriceInexpensive());
        CheckBox checkBoxPriceModerate = new CheckBox("Moderate");
        checkBoxPriceModerate.setSelected(searchFilter.isSelectedPriceModerate());
        CheckBox checkBoxPriceExpensive = new CheckBox("Expensive");
        checkBoxPriceExpensive.setSelected(searchFilter.isSelectedPriceExpensive());
        CheckBox checkBoxPriceVeryExpensive = new CheckBox("Very Expensive");
        checkBoxPriceVeryExpensive.setSelected(searchFilter.isSelectedPriceVeryExpensive());
        Label labelRating = new Label("Minimum Rating");
        Spinner<Integer> ratingSpinner = new Spinner<>(1, 5, searchFilter.getSelectedRating());
        Button resetButton = new Button("reset");
        VBox vBox = new VBox(labelCuisine, checkBoxCuisineGerman, checkBoxCuisineItalian, checkBoxCuisineChinese,
                new Label(" "), labelPrice, checkBoxPriceInexpensive, checkBoxPriceModerate, checkBoxPriceExpensive,
                checkBoxPriceVeryExpensive, new Label(" "), labelRating, ratingSpinner, resetButton);

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
            searchFilter.refreshFlter();
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
            searchFilter.selectRating(ratingSpinner.getValue());
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
            ratingSpinner.getValueFactory().setValue(1);
            searchFilter.resetFilter();
        });

    }


}
