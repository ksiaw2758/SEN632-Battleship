package systemoutgames;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import main.Main;

import java.io.IOException;
import java.net.URL;

public class CurrentGameController {

    private Player playerOne;
    private Player playerTwo;

    public CurrentGameController(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;

    }

    @FXML
    void submitShips(ActionEvent event) {

        URL gameScreen = getClass().getResource("/main/SceneGameplay.fxml");
        AnchorPane paneTwo = null;
        try {
            paneTwo = FXMLLoader.load( gameScreen );
        } catch (IOException e) {
            e.printStackTrace();
        }

        BorderPane border = Main.getRoot();
        border.setCenter(paneTwo);
    }
}
