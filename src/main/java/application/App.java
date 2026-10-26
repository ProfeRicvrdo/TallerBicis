package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.Path;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // cargamos la vista que crearon ustedes en Scene Builder
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Path.GESTIONAR_BICICLETAS_VIEW));
        Parent panel = loader.load();
        stage.setTitle("Taller de Bicicletas");
        stage.setScene(new Scene(panel));
        stage.show();
    }

}
