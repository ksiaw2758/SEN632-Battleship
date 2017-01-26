package systemoutgames;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import main.Main;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class CurrentGameController {

    private Player playerOne;
    private Player playerTwo;

    private Grid primaryGrid;
    private Grid secondaryGrid;


    public CurrentGameController(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;

    }

    @FXML
    void submitShips(ActionEvent event) {

        URL gameScreen = getClass().getResource("/main/SceneGameplay.fxml");

        FXMLLoader loader = new FXMLLoader(gameScreen);

        List<Ship> playerOneShips = playerOne.selectShips();
        List<Ship> playerTwoShips = playerTwo.selectShips();

        createGrids(playerOneShips, playerTwoShips);

        loader.setController(this);

        AnchorPane paneGame = null;
        try {
            paneGame = FXMLLoader.load( gameScreen );
        } catch (IOException e) {
            e.printStackTrace();
        }

        BorderPane border = Main.getRoot();
        border.setCenter(paneGame);
    }

    private void createGrids(List<Ship> playerOneShips, List<Ship> playerTwoShips) {
        primaryGrid = new Grid();
        secondaryGrid = new Grid();

        primaryGrid.placeShips(playerOneShips);
        secondaryGrid.placeShips(playerTwoShips);
    }



}
