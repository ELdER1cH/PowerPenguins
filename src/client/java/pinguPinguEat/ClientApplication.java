package pinguPinguEat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

public class ClientApplication extends Application {
    private ConfigurableApplicationContext applicationContext;
    private Stage stage;
    private final String startView;

//    @Override
//    public void init() throws Exception {
//        super.init();
//    }

    // ??
    public ClientApplication() {
        startView = "ClientBase.fxml";
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.stage = primaryStage;

        // Hier wird das Fenster für den Start konfiguriert
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource(startView)));
        stage.setTitle("PinguPinguEat");
        stage.setScene(scene);

        stage.show();
    }
}
