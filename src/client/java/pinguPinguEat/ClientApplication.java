package pinguPinguEat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.springframework.context.ConfigurableApplicationContext;
import pinguPinguEat.view.SceneController;

import java.io.IOException;

public class ClientApplication extends Application {
    private ConfigurableApplicationContext applicationContext;
    private Stage stage;
    private final String startView;
    private FXMLLoader loader;
    private SceneController controller;

//    @Override
//    public void init() throws Exception {
//        super.init();
//    }


    public FXMLLoader getLoader() {
        return loader;
    }

    public void setLoader(FXMLLoader loader) {
        this.loader = loader;
    }

    public SceneController getController() {
        return controller;
    }

    public void setController(SceneController controller) {
        this.controller = controller;
    }

    // ??
    public ClientApplication() {
        startView = "ClientBase.fxml";
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        this.stage = primaryStage;

        // resize stage to screen size of this device
        int width = (int) Screen.getPrimary().getBounds().getWidth();
        int height = (int) Screen.getPrimary().getBounds().getHeight();
        this.stage.setWidth(width);
        this.stage.setHeight(height);

        // this actually works better but the window size hast to be adjusted whenever the scene changes
        // will deal w/ this later
        // this.stage.setMaximized(true);


        // Hier wird das Fenster für den Start konfiguriert
        loader = new FXMLLoader(getClass().getResource(startView));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setTitle("PinguPinguEat");
        stage.setScene(scene);
        controller = loader.getController();
        controller.loadRestaurants();


        stage.show();
    }
}
