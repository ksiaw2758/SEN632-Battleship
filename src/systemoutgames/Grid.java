package systemoutgames;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.List;
import java.util.stream.Collectors;

public class Grid {

    @FXML
    private GridPane gridPane;

    private Square[][] squares = new Square[10][10];

    public void initialize() {
        System.out.print(gridPane);
    }

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
            ship.getAllLocations().stream().forEach(location -> {
                squares[location.getStartingX()][location.getStartingY()] = new Square(ship);
                Rectangle rec = getRectangle(getLocationAsString(location));
                rec.setFill(Color.DARKGRAY);
            });
        }
    }

    private Rectangle getRectangle(String locationAsString) {
        return gridPane.getChildren().stream()
                .filter(node ->
                        locationAsString.equals(node.getId())
                )
                .map(node -> (Rectangle) node)
                .collect(Collectors.toList()).get(0);
    }

    public HitResult hit(Location location) {
        Square square = squares[location.getStartingX()][location.getStartingY()];

        HitResult result = square.hit();

        if(result.isShipHit()){
            getRectangle(getLocationAsString(location)).setFill(Color.RED);
        } else {
            getRectangle(getLocationAsString(location)).setFill(Color.LIGHTBLUE);
        }

        return result;
    }

    private String getLocationAsString(Location location) {
        int ascii = location.getStartingX() + 97;
        Character character = new Character((char) ascii);
        int y = location.getStartingY() + 1;
        return character.toString() + y;
    }
}
