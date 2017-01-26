package systemoutgames;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import main.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CurrentGameController {

    private Player playerOne;
    private Player playerTwo;

    private Grid primaryGrid;

    @FXML
    private String aircraftCarrierLocation;
    @FXML
    private String aircraftCarrierDirection;

    @FXML
    private String battleShipLocation;
    @FXML
    private String battleShipDirection;

    @FXML
    private String submarineLocation;
    @FXML
    private String submarineDirection;

    @FXML
    private String crusierLocation;
    @FXML
    private String crusierDirection;

    @FXML
    private String destroyerLocation;
    @FXML
    private String destroyerDirection;



    public CurrentGameController(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;

    }

    @FXML
    void submitShips(ActionEvent event) {

        URL gameScreen = getClass().getResource("/main/SceneGameplay.fxml");

        FXMLLoader loader = new FXMLLoader(gameScreen);

        List<Ship> ships = createShips();

        createGrids(ships);

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

    private List<Ship> createShips() {
        List<Ship> ships = new ArrayList<>();

        ships.add(new Ship(
                "Aircarft Carrier",
                5,
                new Location(aircraftCarrierLocation.charAt(0), aircraftCarrierLocation.charAt(0), getDirection(aircraftCarrierDirection))
        ));

        ships.add(new Ship(
                "Battle Ship",
                4,
                new Location(battleShipLocation.charAt(0), battleShipLocation.charAt(0), getDirection(battleShipDirection))
        ));

        ships.add(new Ship(
                "Submarine",
                3,
                new Location(submarineLocation.charAt(0), submarineLocation.charAt(0), getDirection(submarineDirection))
        ));

        ships.add(new Ship(
                "Crusier",
                3,
                new Location(crusierLocation.charAt(0), crusierLocation.charAt(0), getDirection(crusierDirection))
        ));

        ships.add(new Ship(
                "Destroyer",
                3,
                new Location(destroyerLocation.charAt(0), destroyerLocation.charAt(0), getDirection(destroyerDirection))
        ));

        return ships;
    }

    private Direction getDirection(String shipDirection) {
        String direction = shipDirection.toLowerCase();

        switch(direction){
            case "horizontal":
                return Direction.HORIZONTAL;
            case "vertical":
                return Direction.VERTICLE;
            default:
                return Direction.HORIZONTAL;
        }
    }

    private void createGrids(List<Ship> ships) {
        primaryGrid = new Grid();

        primaryGrid.placeShips(ships);
    }



}
