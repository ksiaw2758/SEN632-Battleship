package main;

import java.io.IOException;
import java.net.URL;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import systemoutgames.AIPlayer;
import systemoutgames.CurrentGameController;
import systemoutgames.Player;

public class ApplicationController {

    @FXML // fx:id="displayOne"
    private MenuItem displayOne; // Value injected by FXMLLoader

    @FXML // fx:id="displayTwo"
    private MenuItem displayTwo; // Value injected by FXMLLoader

    @FXML // fx:id="displayThree"
    private MenuItem displayThree; // Value injected by FXMLLoader

    @FXML // fx:id="displayFour"
    private MenuItem displayFour; // Value injected by FXMLLoader

    @FXML
    void switchToMain(ActionEvent event) {

        try {

            URL paneOneUrl = getClass().getResource("SceneMainMenu.fxml");
            AnchorPane paneOne = FXMLLoader.load( paneOneUrl );

            BorderPane border = Main.getRoot();
            border.setCenter(paneOne);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void switchToCredits(ActionEvent event) {

        try {

            URL paneTwoUrl = getClass().getResource("SceneCredits.fxml");
            AnchorPane paneTwo = FXMLLoader.load( paneTwoUrl );

            BorderPane border = Main.getRoot();
            border.setCenter(paneTwo);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void switchToGame(ActionEvent event) {

        try {

            URL paneThreeUrl = getClass().getResource("SceneUsername.fxml");
            FXMLLoader loader = new FXMLLoader(paneThreeUrl);
            AnchorPane paneThree = loader.load();

            BorderPane border = Main.getRoot();
            border.setCenter(paneThree);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void submitPlayerName(ActionEvent event) {
        URL shipSelection = getClass().getResource("SceneShipSelection.fxml");
        FXMLLoader loader = new FXMLLoader(shipSelection);

        loader.setController(new CurrentGameController(new Player("Player 1"), new AIPlayer("Captain Ahab")));


        AnchorPane paneThree = null;
        try {
            paneThree = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BorderPane border = Main.getRoot();
        border.setCenter(paneThree);

        loader.setController(new CurrentGameController(new Player("Player 1"), new AIPlayer("Captain Ahab")));
    }

    @FXML
    void switchToOptions(ActionEvent event) {

        try {

            URL paneFourUrl = getClass().getResource("SceneOptions.fxml");
            AnchorPane paneFour = FXMLLoader.load( paneFourUrl );

            BorderPane border = Main.getRoot();
            border.setCenter(paneFour);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void exitGame(ActionEvent event) {

        Platform.exit();
    }
}