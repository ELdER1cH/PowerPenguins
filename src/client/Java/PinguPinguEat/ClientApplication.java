package PinguPinguEat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ClientApplication extends Application {
    private ConfigurableApplicationContext applicationContext;
    private Stage stage;


    @Override
    public void start(Stage primaryStage) throws IOException {
        URL url = new File("src/client/resources/PinguPinguEat/ClientBase.fxml").toURI().toURL();
        this.stage =  primaryStage;
        FXMLLoader fxmlLoader = new FXMLLoader(url);
        Scene scene = new Scene(fxmlLoader.load(),1080,720);
        stage.setTitle("Build 0.0.0.1");
        stage.setScene(scene);
        stage.show();
    }
}
