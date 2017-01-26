package systemoutgames;

public class Square {

    private Ship ship;
    private boolean beenHit;

    public Square(Ship ship) {
        this.ship = ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }
}
