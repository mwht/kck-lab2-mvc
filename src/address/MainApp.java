package address;

import address.model.Person;
import address.view.PersonOverviewController;
import com.sun.tools.javac.Main;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    private ObservableList<Person> personData = FXCollections.observableArrayList();

    public MainApp() {
        personData.add(new Person("Hans", "Muster"));
        personData.add(new Person("Ruth", "Mueller"));
        personData.add(new Person("Heinz", "Kurz"));
        personData.add(new Person("Cornelia", "Meier"));
        personData.add(new Person("Werner", "Meyer"));
        personData.add(new Person("Lydia", "Kunz"));
        personData.add(new Person("Anna", "Best"));
        personData.add(new Person("Stefan", "Meier"));
        personData.add(new Person("Martin", "Mueller"));
    }

    public ObservableList<Person> getPersonData() {
        return personData;
    }

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

            PersonOverviewController personOverviewController = loader.getController();
            personOverviewController.setMainApp(this);
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
