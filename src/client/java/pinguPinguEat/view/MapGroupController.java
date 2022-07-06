package pinguPinguEat.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class MapGroupController extends Application {

    static { // use system proxy settings when standalone application
        System.setProperty("java.net.useSystemProxies", "true");
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        // create web engine and view
        WebEngine webEngine = new WebEngine(getClass().getResource("googlemap.html").toString());
        WebView webView = new WebView(webEngine);
        // create scene
        stage.setTitle("Web Map");
        Scene scene = new Scene(webView, 1000, 700, Color.web("#666970"));
        stage.setScene(scene);
        // show stage
        stage.setVisible(true);
    }
}
