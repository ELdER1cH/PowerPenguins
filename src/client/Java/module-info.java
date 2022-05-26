module Java.PinguPinguEat {
    requires javafx.controls;
    requires javafx.fxml;
    requires spring.context;
    requires spring.boot.autoconfigure;


    opens PinguPinguEat to javafx.fxml;
    exports PinguPinguEat;
}