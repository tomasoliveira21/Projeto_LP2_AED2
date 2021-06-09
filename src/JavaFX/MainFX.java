package JavaFX;

import edu.ufp.inf.lp2.geocaching.UserAdmin;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainFX extends Application {

    @Override
    public void start(Stage stage) {
        try {

            //UserAdmin.readAll();

            UserAdmin.readUsersBin();
            UserAdmin.readCachesBin();
            UserAdmin.readGraphBin();



            Parent root = FXMLLoader.load(getClass().getResource("JavaFX.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();



        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
