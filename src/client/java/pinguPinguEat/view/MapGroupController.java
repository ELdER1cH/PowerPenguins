package pinguPinguEat.view;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class MapGroupController extends Application {

    static { // use system proxy settings when standalone application
        System.setProperty("java.net.useSystemProxies", "true");
    }
    @FXML
    private WebView webView;
    @FXML
        // This method is called by the FXMLLoader when initialization is complete
        //The button to confirm the search and the TextField for searching haven't yet been added in FXML, should happen ASAP
    void initialize() {
        assert webView != null : "fx:id=\"webView\" was not injected: check your FXML file 'MapGroupView.fxml'.";
    }

    @Override
    public void start(Stage stage) {
        // I'll keep this here for now, but I think manipulating the @FXML component is the way to go
        //WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        //Below is what it should be, but the html doc doesn't exist yet so we're using a proxy website for now to test stuff
        webEngine.load(getClass().getResource("googlemaps.html").toExternalForm());
        webEngine.load("http://www.google.com/");
        // create scene
        stage.setTitle("Web Map");
        Scene scene = new Scene(webView, 1000, 700, Color.web("#666970"));
        stage.setScene(scene);
        // show stage
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
