package CrudJava;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class ControllerPanel {
    @FXML
    public void ZamknijAplikacje(ActionEvent event) {
        System.exit(0);
    }

    public void Informacje(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informacje o Programie");
        alert.setHeaderText("To jest aplikacja CRUD z wykorzystaniem javaFX oraz sqlite");
        alert.setContentText("Po więcej informacji spytaj twórcę");
        alert.show();
    }

}
