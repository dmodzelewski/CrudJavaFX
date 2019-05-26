package CrudJava;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage scena;
    private BorderPane panel;

    @Override
    public void start(Stage scena) throws Exception {
        this.scena = scena;
        inicjalizacja();
    }


    public void inicjalizacja() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("Widok/baza.fxml"));
            panel = (BorderPane) loader.load();
            Scene scene = new Scene(panel);
            scena.setScene(scene);
            scena.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
