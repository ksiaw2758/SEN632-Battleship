package systemoutgames;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AIPlayer extends Player{

    private static final int gridSize = 10;

    public AIPlayer(String name) {
        super(name);
    }

    @Override
    public List<Ship> selectShips() {

        List<Ship> ships = new ArrayList<>();

        ships.add(placeShip("Aircraft Carrier", 5, ships));
        ships.add(placeShip("Battle Ship", 4, ships));
        ships.add(placeShip("Submarine", 3, ships));
        ships.add(placeShip("Cruiser", 3, ships));
        ships.add(placeShip("Destroyer", 2, ships));
        return ships;
    }

    private int getRandomNumber(int bound) {
        Random rand = new Random();

        return rand.nextInt(bound);
    }

    private Ship placeShip(String name, int startingHealth, List<Ship> currentlyPlacedShips) {

        Ship newShip = new Ship(name, startingHealth, new Location(getRandomNumber(gridSize),getRandomNumber(gridSize), getRandomDirection()));

        if(ShipPlacementHelper.collisionDetected(newShip, currentlyPlacedShips) || ShipPlacementHelper.notInsideGrid(newShip)) {
            return placeShip(name, startingHealth, currentlyPlacedShips);
        }
        return newShip;
    }



    private Direction getRandomDirection() {
        switch (getRandomNumber(2)) {
            case 0:
                return Direction.HORIZONTAL;
            case 1:
                return Direction.VERTICLE;
            default:
                return Direction.HORIZONTAL;
        }
    }
}
