package pinguPinguEat;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.ConfigurableApplicationContext;
import pinguPinguEat.view.SceneController;

import java.io.IOException;

public class ClientApplication extends Application {
    private ConfigurableApplicationContext applicationContext;
    private Stage stage;
    private final String startView;
    private FXMLLoader loader;
    private SceneController sceneController;

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
        return sceneController;
    }

    public void setController(SceneController sceneController) {
        this.sceneController = sceneController;
    }

    public ClientApplication() {
        startView = "ClientBase.fxml";
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        this.stage = primaryStage;

        this.stage.setMaximized(true);


        // Hier wird das Fenster für den Start konfiguriert
        loader = new FXMLLoader(getClass().getResource(startView));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setTitle("PinguPinguEat");
        stage.setScene(scene);
        sceneController = loader.getController();
        sceneController.switchToMapView(new ActionEvent());
        sceneController.loadRestaurants();


        stage.show();
    }
}
