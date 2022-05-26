package PinguPinguEat;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Client {

    // Hier Programm starten
    // Der ganze Front Ent Scheiß wird in resources gespeichert gemeinsam mit den Bildern
    // Ihr könnt euch die fxml Datei auch in dem Scene Builder anschauen, in dem habe ich das gemacht.
    // Dazu könnt ihr auch den Scene Builder zu Intellij hinzufügen damit das einfacher geht, dazu einfach kurz googeln
    // https://www.jetbrains.com/help/idea/opening-fxml-files-in-javafx-scene-builder.html oder hier auf den Link klicken
    public static void main(String[] args) {
        Application.launch(ClientApplication.class,args);
    }

}
