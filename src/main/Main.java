package main;

import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {

    private static BorderPane root = new BorderPane();

    public static BorderPane getRoot() {

        return root;
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        URL menuBarUrl = getClass().getResource("SceneMenuBar.fxml");
        MenuBar bar = FXMLLoader.load( menuBarUrl );

        URL paneOneUrl = getClass().getResource("SceneMainMenu.fxml");
        AnchorPane paneOne = FXMLLoader.load( paneOneUrl );

        root.setTop(bar);
        root.setCenter(paneOne);

        Scene scene = new Scene(root, 800, 625);
        scene
                .getStylesheets()
                .add(getClass()
                        .getResource("ApplicationSceneStyles.css")
                        .toExternalForm());

        primaryStage.setTitle("System.out.gaming Presents: BATTLESHIP");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}