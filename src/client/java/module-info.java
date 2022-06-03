module Java.PinguPinguEat {
    requires javafx.controls;
    requires javafx.fxml;
    requires spring.context;
    requires spring.boot.autoconfigure;
    requires spring.webflux;
    requires pinguPinguEat;
    requires spring.web;


    opens pinguPinguEat.controller to javafx.fxml;
    exports pinguPinguEat;
    opens pinguPinguEat.view to javafx.fxml;
}