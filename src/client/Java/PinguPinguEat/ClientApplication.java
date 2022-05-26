package PinguPinguEat;

import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.context.ConfigurableApplicationContext;

public class ClientApplication extends Application {
    private ConfigurableApplicationContext applicationContext;

    /*@Override
    public void init() {
        applicationContext =  new SpringApplicationBuilder(ClientApplication.class).run();
    }*/

    /*@Override
    public void stop() {
        applicationContext.close();
        Platform.exit();
    }*/

    @Override
    public void start(Stage primaryStage) {
        primaryStage.show();
    }

    /*private static class StageReadyEvent extends ApplicationEvent {
        public StageReadyEvent(Stage primaryStage) {
            super(primaryStage);
        }
    }*/
}
