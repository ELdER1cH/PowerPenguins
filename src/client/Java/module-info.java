module Java.PinguPinguEat {
    requires javafx.controls;
    requires javafx.fxml;
    requires spring.context;
    requires spring.boot.autoconfigure;


    opens PinguPinguEat.Controller to javafx.fxml;
    exports PinguPinguEat;
}