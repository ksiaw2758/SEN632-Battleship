package systemoutgames;

import java.util.List;

public class Grid {

    private Square[][] squares = new Square[10][10];

    public Grid() {
        buildSquares();
    }

    private void buildSquares() {
        for(int i = 0; i < 10; i++ ) {
            for(int j = 0; j < 10; j++) {
                squares[i][j] = new Square(null);
            }
        }
    }

    public void placeShips(List<Ship> ships){
        for(Ship ship : ships) {
            int x = ship.getLocation().getStartingX();
            int y = ship.getLocation().getStartingY();

            ship.getAllLocations().stream().forEach(location -> {
                squares[location.getStartingX()][location.getStartingY()] = new Square(ship);
            });
        }
    }
}
