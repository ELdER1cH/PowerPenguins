package PinguPinguEat.Controller;


import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ClientBase {
    @FXML
    private Label text;

    @FXML
    private Label HelloSign;

    @FXML
    protected void onHelloButtonClick(){
        HelloSign.setText("Have Fun!");
    }
}
