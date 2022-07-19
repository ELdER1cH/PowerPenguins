package pinguPinguEat.view;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pinguPinguEat.logic.RestaurantLogic;
import pinguPinguEat.restaurants.Restaurant;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import java.util.List;




public class MapGroupView {
    public ObservableList<Restaurant> restaurants = FXCollections.observableArrayList();
    public ObservableMap<Integer, ImageView> markers = FXCollections.observableHashMap();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView eight;

    @FXML
    private ImageView eighteen;

    @FXML
    private ImageView eleven;

    @FXML
    private ImageView fifteen;

    @FXML
    private ImageView fifty;

    @FXML
    private ImageView five;

    @FXML
    private ImageView four;

    @FXML
    private ImageView fourteen;

    @FXML
    private ImageView fourty;

    @FXML
    private ImageView fourtyeight;

    @FXML
    private ImageView fourtyfive;

    @FXML
    private ImageView fourtyfour;

    @FXML
    private ImageView fourtynine;

    @FXML
    private ImageView fourtyone;

    @FXML
    private ImageView fourtyseven;

    @FXML
    private ImageView fourtysix;

    @FXML
    private ImageView fourtythree;

    @FXML
    private ImageView fourtytwo;

    @FXML
    private ImageView nine;

    @FXML
    private ImageView nineteen;

    @FXML
    private ImageView one;

    @FXML
    private ImageView seven;

    @FXML
    private ImageView seventeen;

    @FXML
    private ImageView six;

    @FXML
    private ImageView sixteen;

    @FXML
    private ImageView ten;

    @FXML
    private ImageView thirteen;

    @FXML
    private ImageView thirty;

    @FXML
    private ImageView thirtyeight;

    @FXML
    private ImageView thirtyfive;

    @FXML
    private ImageView thirtyfour;

    @FXML
    private ImageView thirtynine;

    @FXML
    private ImageView thirtyone;

    @FXML
    private ImageView thirtyseven;

    @FXML
    private ImageView thirtysix;

    @FXML
    private ImageView thirtythree;

    @FXML
    private ImageView thirtytwo;

    @FXML
    private ImageView three;

    @FXML
    private ImageView twelve;

    @FXML
    private ImageView twenty;

    @FXML
    private ImageView twentyeight;

    @FXML
    private ImageView twentyfive;

    @FXML
    private ImageView twentyfour;

    @FXML
    private ImageView twentynine;

    @FXML
    private ImageView twentyone;

    @FXML
    private ImageView twentyseven;

    @FXML
    private ImageView twentysix;

    @FXML
    private ImageView twentythree;

    @FXML
    private ImageView twentytwo;

    @FXML
    private ImageView two;

    @FXML
    void initialize() {
        assert eight != null : "fx:id=\"eight\" was not injected: check your FXML file 'MapGroupView.fxml'.";
        assert eighteen != null : "fx:id=\"eighteen\" was not injected: check your FXML file 'MapGroupView.fxml'.";
        assert eleven != null : "fx:id=\"eleven\" was not injected: check your FXML file 'MapGroupView.fxml'.";
        assert fifteen != null : "fx:id=\"fifteen\" was not injected: check your FXML file 'MapGroupView.fxml'.";
        assert fifty != null : "fx:id=\"fifty\" was not injected: check your FXML file 'MapGroupView.fxml'.";
        assert five != null : "fx:id=\"five\" was not injected: check your FXML file 'MapGroupView.fxml'.";
        assert four != null : "fx:id=\"four\" was not injected: check your FXML file 'MapGroupView.fxml'.";
        assert fourteen != null : "fx:id=\"fourteen\" was not injected: check your FXML file 'MapGroupView.fxml'.";
        assert fourty != null : "fx:id=\"fourty\" was not injected: check your FXML file 'MapGroupView.fxml'.";
        assert fourtyeight != null : "fx:id=\"fourtyeight\" was not injected: check your FXML file 'MapGroupView.fxml'.";
        assert fourtyfive != null : "fx:id=\"fourtyfive\" was not injected: check your FXML file 'MapGroupView.fxml'.";
        assert fourtyfour != null : "fx:id=\"fourtyfour\" was not injected: check your FXML file 'MapGroupView.fxml'.";
        assert fourtynine != null : "fx:id=\"fourtynine\" was not injected: check your FXML file 'MapGroupView.fxml'.";
        assert fourtyone != null : "fx:id=\"fourtyone\" was not injected: check your FXML file 'MapGroupView.fxml'.";
        assert fourtyseven != null : "fx:id=\"fourtyseven\" was not injected: check your FXML file 'MapGroupView.fxml'.";
        assert fourtysix != null : "fx:id=\"fourtysix\" was not injected: check your FXML file 'MapGroupView.fxml'.";
        assert fourtythree != null : "fx:id=\"fourtythree\" was not injected: check your FXML file 'MapGroupView.fxml'.";
        assert fourtytwo != null : "fx:id=\"fourtytwo\" was not injected: check your FXML file 'MapGroupView.fxml'.";
        assert nine != null : "fx:id=\"nine\" was not injected: check your FXML file 'MapGroupView.fxml'.";
        assert nineteen != null : "fx:id=\"nineteen\" was not injected: check your FXML file 'MapGroupView.fxml'.";
        assert one != null : "fx:id=\"one\" was not injected: check your FXML file 'MapGroupView.fxml'.";
        assert seven != null : "fx:id=\"seven\" was not injected: check your FXML file 'MapGroupView.fxml'.";
        assert seventeen != null : "fx:id=\"seventeen\" was not injected: check your FXML file 'MapGroupView.fxml'.";
        assert six != null : "fx:id=\"six\" was not injected: check your FXML file 'MapGroupView.fxml'.";
        assert sixteen != null : "fx:id=\"sixteen\" was not injected: check your FXML file 'MapGroupView.fxml'.";
        assert ten != null : "fx:id=\"ten\" was not injected: check your FXML file 'MapGroupView.fxml'.";
        assert thirteen != null : "fx:id=\"thirteen\" was not injected: check your FXML file 'MapGroupView.fxml'.";
        assert thirty != null : "fx:id=\"thirty\" was not injected: check your FXML file 'MapGroupView.fxml'.";
        assert thirtyeight != null : "fx:id=\"thirtyeight\" was not injected: check your FXML file 'MapGroupView.fxml'.";
        assert thirtyfive != null : "fx:id=\"thirtyfive\" was not injected: check your FXML file 'MapGroupView.fxml'.";
        assert thirtyfour != null : "fx:id=\"thirtyfour\" was not injected: check your FXML file 'MapGroupView.fxml'.";
        assert thirtynine != null : "fx:id=\"thirtynine\" was not injected: check your FXML file 'MapGroupView.fxml'.";
        assert thirtyone != null : "fx:id=\"thirtyone\" was not injected: check your FXML file 'MapGroupView.fxml'.";
        assert thirtyseven != null : "fx:id=\"thirtyseven\" was not injected: check your FXML file 'MapGroupView.fxml'.";
        assert thirtysix != null : "fx:id=\"thirtysix\" was not injected: check your FXML file 'MapGroupView.fxml'.";
        assert thirtythree != null : "fx:id=\"thirtythree\" was not injected: check your FXML file 'MapGroupView.fxml'.";
        assert thirtytwo != null : "fx:id=\"thirtytwo\" was not injected: check your FXML file 'MapGroupView.fxml'.";
        assert three != null : "fx:id=\"three\" was not injected: check your FXML file 'MapGroupView.fxml'.";
        assert twelve != null : "fx:id=\"twelve\" was not injected: check your FXML file 'MapGroupView.fxml'.";
        assert twenty != null : "fx:id=\"twenty\" was not injected: check your FXML file 'MapGroupView.fxml'.";
        assert twentyeight != null : "fx:id=\"twentyeight\" was not injected: check your FXML file 'MapGroupView.fxml'.";
        assert twentyfive != null : "fx:id=\"twentyfive\" was not injected: check your FXML file 'MapGroupView.fxml'.";
        assert twentyfour != null : "fx:id=\"twentyfour\" was not injected: check your FXML file 'MapGroupView.fxml'.";
        assert twentynine != null : "fx:id=\"twentynine\" was not injected: check your FXML file 'MapGroupView.fxml'.";
        assert twentyone != null : "fx:id=\"twentyone\" was not injected: check your FXML file 'MapGroupView.fxml'.";
        assert twentyseven != null : "fx:id=\"twentyseven\" was not injected: check your FXML file 'MapGroupView.fxml'.";
        assert twentysix != null : "fx:id=\"twentysix\" was not injected: check your FXML file 'MapGroupView.fxml'.";
        assert twentythree != null : "fx:id=\"twentythree\" was not injected: check your FXML file 'MapGroupView.fxml'.";
        assert twentytwo != null : "fx:id=\"twentytwo\" was not injected: check your FXML file 'MapGroupView.fxml'.";
        assert two != null : "fx:id=\"two\" was not injected: check your FXML file 'MapGroupView.fxml'.";
        markers.put(1, one);
        markers.put(2, two);
        markers.put(3, three);
        markers.put(4, four);
        markers.put(5, five);
        markers.put(6, six);
        markers.put(7, seven);
        markers.put(8, eight);
        markers.put(9, nine);
        markers.put(10, ten);
        markers.put(11, eleven);
        markers.put(12, twelve);
        markers.put(13, thirteen);
        markers.put(14, fourteen);
        markers.put(15, fifteen);
        markers.put(16, sixteen);
        markers.put(17, seventeen);
        markers.put(18, eighteen);
        markers.put(19, nineteen);
        markers.put(20, twenty);
        markers.put(21, twentyone);
        markers.put(22, twentytwo);
        markers.put(23, twentythree);
        markers.put(24, twentyfour);
        markers.put(25, twentyfive);
        markers.put(26, twentysix);
        markers.put(27, twentyseven);
        markers.put(28, twentyeight);
        markers.put(29, twentynine);
        markers.put(30, thirty);
        markers.put(31, thirtyone);
        markers.put(32, thirtytwo);
        markers.put(33, thirtythree);
        markers.put(34, thirtyfour);
        markers.put(35, thirtyfive);
        markers.put(36, thirtysix);
        markers.put(37, thirtyseven);
        markers.put(38, thirtyeight);
        markers.put(39, thirtynine);
        markers.put(40, fourty);
        markers.put(41, fourtyone);
        markers.put(42, fourtytwo);
        markers.put(43, fourtythree);
        markers.put(44, fourtyfour);
        markers.put(45, fourtyfive);
        markers.put(46, fourtysix);
        markers.put(47, fourtyseven);
        markers.put(48, fourtyeight);
        markers.put(49, fourtynine);
        markers.put(50, fifty);

        restaurants.addAll(RestaurantLogic.getAllRestaurants());
        determinevisibility();

    }

    public void setRestaurants(ObservableList<Restaurant> restaurants) {
        this.restaurants = restaurants;
        determinevisibility();
    }

    public void determinevisibility() {
        List<Integer> IDstorage = new ArrayList<>();
        for (int i = 0; i < restaurants.size(); i++) {
            IDstorage.add(restaurants.get(i).getMapID());
        }
        for (int i = 0; i < markers.keySet().size(); i++) {
            if (IDstorage.contains(markers.keySet().stream().toList().get(i))) {
                markers.get(markers.keySet().stream().toList().get(i)).setVisible(true);
            } else {
                markers.get(markers.keySet().stream().toList().get(i)).setVisible(false);
            }
        }
    }


}
