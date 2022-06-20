package pinguPinguEat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Screen;
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

        // resize stage to screen size of this device
        int width = (int) Screen.getPrimary().getBounds().getWidth();
        int height = (int) Screen.getPrimary().getBounds().getHeight();
        this.stage.setWidth(width);
        this.stage.setHeight(height);

        // this actually works better but the window size hast to be adjusted whenever the scene changes
        // will deal w/ this later
        // this.stage.setMaximized(true);


        // Hier wird das Fenster für den Start konfiguriert
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource(startView)));
        stage.setTitle("PinguPinguEat");
        stage.setScene(scene);

        stage.show();
    }
}
