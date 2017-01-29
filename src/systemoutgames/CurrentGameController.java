package systemoutgames;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import main.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static systemoutgames.ShipSelectionBuilder.shipSelectionBuilder;

public class CurrentGameController {

    @FXML
    public TextField aircraftCarrierCoordinate;
    @FXML
    public ComboBox<String> aircraftCarrierDirection;

    @FXML
    public TextField battleshipCoordinate;
    @FXML
    public ComboBox<String> battleShipDirection;

    @FXML
    public TextField submarineCoordinate;
    @FXML
    public ComboBox<String> submarineDirection;

    @FXML
    public TextField cruiserCoordinate;
    @FXML
    public ComboBox<String> cruiserDirection;

    @FXML
    public TextField destroyerCoordinate;
    @FXML
    public ComboBox<String> destroyerDirection;

    private Player playerOne;
    private Player playerTwo;

    private Grid primaryGrid;
    private Grid secondaryGrid;


    public CurrentGameController(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;

    }

    public void initialize() {
        String[] options = {"horizontal", "vertical"};

        aircraftCarrierDirection.getItems().addAll(options);
        battleShipDirection.getItems().addAll(options);
        submarineDirection.getItems().addAll(options);
        cruiserDirection.getItems().addAll(options);
        destroyerDirection.getItems().addAll(options);
    }

    @FXML
    void submitShips(ActionEvent event) {

        URL gameScreen = getClass().getResource("/main/SceneGameplay.fxml");

        FXMLLoader loader = new FXMLLoader(gameScreen);

        List<ShipSelection> selections = buildShipSelections();

        List<Ship> playerOneShips = playerOne.selectShips(selections);
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

    private List<ShipSelection> buildShipSelections() {
        List<ShipSelection> selection = new ArrayList<>();

        selection.add(shipSelectionBuilder().name("Aircraft Carrier").coordinants(aircraftCarrierCoordinate.getText()).direction(aircraftCarrierDirection.getValue()).build());
        selection.add(shipSelectionBuilder().name("Battle Ship").coordinants(battleshipCoordinate.getText()).direction(battleShipDirection.getValue()).build());
        selection.add(shipSelectionBuilder().name("Submarine").coordinants(submarineCoordinate.getText()).direction(submarineDirection.getValue()).build());
        selection.add(shipSelectionBuilder().name("Crusier").coordinants(cruiserCoordinate.getText()).direction(cruiserDirection.getValue()).build());
        selection.add(shipSelectionBuilder().name("Destroyer").coordinants(destroyerCoordinate.getText()).direction(destroyerDirection.getValue()).build());

        return selection;
    }

    private void createGrids(List<Ship> playerOneShips, List<Ship> playerTwoShips) {
        primaryGrid = new Grid();
        secondaryGrid = new Grid();

        primaryGrid.placeShips(playerOneShips);
        secondaryGrid.placeShips(playerTwoShips);
    }



}
