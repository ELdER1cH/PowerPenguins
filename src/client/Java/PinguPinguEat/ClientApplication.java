package PinguPinguEat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

public class ClientApplication extends Application {
    private ConfigurableApplicationContext applicationContext;
    private Stage stage;


    @Override
    public void start(Stage primaryStage) throws IOException {
        this.stage =  primaryStage;
        FXMLLoader fxmlLoader = new FXMLLoader(ClientApplication.class.getResource("ClientBase.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),320,240);
        stage.setTitle("Build 0.0.0.1");
        stage.setScene(scene);
        stage.show();
    }

}
