module Java.PinguPinguEat {
    requires javafx.controls;
    requires javafx.fxml;
    requires spring.context;
    requires spring.boot.autoconfigure;


    opens pinguPinguEat.view to javafx.fxml;
    exports pinguPinguEat;
}