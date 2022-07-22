package pinguPinguEat;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.ConfigurableApplicationContext;
import pinguPinguEat.view.SceneView;

import java.io.IOException;

public class ClientApplication extends Application {
    private ConfigurableApplicationContext applicationContext;
    private Stage stage;
    private final String startView;
    private FXMLLoader loader;
    private SceneView sceneController;

    public ClientApplication() {
        startView = "ClientBase.fxml";
    }

    public Stage getStage() {
        return stage;
    }

    public FXMLLoader getLoader() {
        return loader;
    }

    public void setLoader(FXMLLoader loader) {
        this.loader = loader;
    }

    public SceneView getController() {
        return sceneController;
    }

    public void setController(SceneView sceneController) {
        this.sceneController = sceneController;
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
        stage.show();
    }
}
