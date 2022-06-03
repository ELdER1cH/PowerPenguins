module Java.PinguPinguEat {
    requires javafx.controls;
    requires javafx.fxml;
    requires spring.context;
    requires spring.boot.autoconfigure;
    requires spring.web;


    opens pinguPinguEat.view to javafx.fxml;
    exports pinguPinguEat;
}