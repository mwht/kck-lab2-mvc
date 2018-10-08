package address;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private BorderPane loadRootElement() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
        try {
            BorderPane rootBorderPane = (BorderPane) loader.load();
            return rootBorderPane;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private AnchorPane loadPersonOverview() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("view/PersonOverview.fxml"));
        try {
            AnchorPane rootAnchorPane = (AnchorPane) loader.load();
            return rootAnchorPane;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public void start(Stage primaryStage) {
        BorderPane rootBorderPane = loadRootElement();
        AnchorPane personOverview = loadPersonOverview();
        rootBorderPane.setCenter(personOverview);
        primaryStage.setScene(new Scene(rootBorderPane));
        primaryStage.show();
    }
}
