package systemoutgames;


import java.util.ArrayList;
import java.util.List;

public class AIPlayer extends Player{

    public AIPlayer(String name) {
        super(name);
    }

    @Override
    public List<Ship> selectShips() {
        List<Ship> ships = new ArrayList<>();
        ships.add(new Ship("Aircraft Carrier", 5, new Location(1,1,Direction.HORIZONTAL)));
        ships.add(new Ship("Battle Ship", 4, new Location(3,1,Direction.HORIZONTAL)));
        ships.add(new Ship("Submarine", 3, new Location(7,1,Direction.HORIZONTAL)));
        ships.add(new Ship("Cruiser", 3, new Location(4,8,Direction.VERTICLE)));
        ships.add(new Ship("Destroyer", 2, new Location(7,9,Direction.VERTICLE)));
        return ships;
    }
}
