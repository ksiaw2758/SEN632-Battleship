package systemoutgames;

import javafx.fxml.FXML;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;


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


    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ship> selectShips() {
        List<Ship> ships = new ArrayList<>();

        ships.add(new Ship(
                "Aircarft Carrier",
                5,
                new Location(aircraftCarrierLocation.charAt(0), aircraftCarrierLocation.charAt(0), getShipDirection(aircraftCarrierDirection))
        ));

        ships.add(new Ship(
                "Battle Ship",
                4,
                new Location(battleShipLocation.charAt(0), battleShipLocation.charAt(0), getShipDirection(battleShipDirection))
        ));

        ships.add(new Ship(
                "Submarine",
                3,
                new Location(submarineLocation.charAt(0), submarineLocation.charAt(0), getShipDirection(submarineDirection))
        ));

        ships.add(new Ship(
                "Crusier",
                3,
                new Location(crusierLocation.charAt(0), crusierLocation.charAt(0), getShipDirection(crusierDirection))
        ));

        ships.add(new Ship(
                "Destroyer",
                2,
                new Location(destroyerLocation.charAt(0), destroyerLocation.charAt(0), getShipDirection(destroyerDirection))
        ));

        return ships;
    }

    private Direction getShipDirection(String shipDirection) {
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



}
