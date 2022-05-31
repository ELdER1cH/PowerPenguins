module Java.PinguPinguEat {
    requires javafx.controls;
    requires javafx.fxml;
    requires spring.context;
    requires spring.boot.autoconfigure;


    opens pinguPinguEat.Controller to javafx.fxml;
    exports pinguPinguEat;
    opens pinguPinguEat.view to javafx.fxml;
}