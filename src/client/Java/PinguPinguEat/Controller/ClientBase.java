package PinguPinguEat.Controller;


import javafx.fxml.FXML;
import javafx.scene.control.Label;

//Controller für die Client Base fxml Datei -> die ganze Logic von der Anzeige wird hier gemacht
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
