package systemoutgames;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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

//    @FXML private Parent primaryGrid;
    @FXML private Grid primaryGridController;
    @FXML private Grid secondaryGridController;

    @FXML
    public TextField hitSelection;

    @FXML
    private Label playerOneLabel;
    @FXML
    private Label playerTwoLabel;


    private Player playerOne;
    private Player playerTwo;


    private List<Ship> playerTwoSunkenShips;
    private List<Ship> playerOneSunkenShips;

    public CurrentGameController(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;

        playerTwoSunkenShips = new ArrayList<>();
        playerOneSunkenShips = new ArrayList<>();

    }

    public void initialize() {
        String[] options = {"horizontal", "vertical"};
        if(aircraftCarrierDirection != null) {
            aircraftCarrierDirection.getItems().addAll(options);
            battleShipDirection.getItems().addAll(options);
            submarineDirection.getItems().addAll(options);
            cruiserDirection.getItems().addAll(options);
            destroyerDirection.getItems().addAll(options);
        }

        if(playerOneLabel != null) {
            playerOneLabel.setText(playerOne.getName());
            playerTwoLabel.setText(playerTwo.getName());
        }
    }

    @FXML
    void submitHit(ActionEvent event) {

        HitResult result = secondaryGridController.hit(new Location(hitSelection.getText().charAt(0), hitSelection.getText().charAt(1), Direction.HORIZONTAL));

        checkResult(result, playerTwoSunkenShips);

        if(playerTwoSunkenShips.size() == 5){
            displayEndOfGame(playerOne);
        } else {
            Location playerTwoHit = playerTwo.selectHit();
            HitResult playerTwoResult = primaryGridController.hit(playerTwoHit);

            checkResult(playerTwoResult, playerOneSunkenShips);

            if(playerTwoSunkenShips.size() == 5){
                displayEndOfGame(playerOne);
            }
        }

    }

    private void displayEndOfGame(Player winner) {

    }

    private void checkResult(HitResult result, List<Ship> sunkenShips) {
        if(result.isShipHit()) {
            playHitSound();
        }
        if(result.isShipSunk()) {
            playShipSunkSound();
            displaySunkShip();
            sunkenShips.add(result.getSunkShip());
        }
    }

    private void displaySunkShip() {

    }

    private void playShipSunkSound() {

    }

    private void playHitSound() {

    }

    @FXML
    void submitShips(ActionEvent event) {

        URL gameScreen = getClass().getResource("/main/SceneGameplay.fxml");

        FXMLLoader loader = new FXMLLoader(gameScreen);

        List<ShipSelection> selections = buildShipSelections();

        List<Ship> playerOneShips = playerOne.selectShips(selections);
        List<Ship> playerTwoShips = playerTwo.selectShips();

        loader.setController(this);

        AnchorPane paneGame = null;
        try {
            paneGame = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BorderPane border = Main.getRoot();
        border.setCenter(paneGame);

        createGrids(playerOneShips, playerTwoShips);
    }

    private List<ShipSelection> buildShipSelections() {
        List<ShipSelection> selection = new ArrayList<>();

        selection.add(shipSelectionBuilder().name("Aircraft Carrier").startingHealth(5).coordinants(aircraftCarrierCoordinate.getText()).direction(aircraftCarrierDirection.getValue()).build());
        selection.add(shipSelectionBuilder().name("Battle Ship").startingHealth(4).coordinants(battleshipCoordinate.getText()).direction(battleShipDirection.getValue()).build());
        selection.add(shipSelectionBuilder().name("Submarine").startingHealth(3).coordinants(submarineCoordinate.getText()).direction(submarineDirection.getValue()).build());
        selection.add(shipSelectionBuilder().name("Crusier").startingHealth(3).coordinants(cruiserCoordinate.getText()).direction(cruiserDirection.getValue()).build());
        selection.add(shipSelectionBuilder().name("Destroyer").startingHealth(2).coordinants(destroyerCoordinate.getText()).direction(destroyerDirection.getValue()).build());

        return selection;
    }

    private void createGrids(List<Ship> playerOneShips, List<Ship> playerTwoShips) {

        primaryGridController.placeShips(playerOneShips);
        secondaryGridController.placeShips(playerTwoShips);
    }



}
