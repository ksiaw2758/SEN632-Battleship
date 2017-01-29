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

    public HitResult hit() {

        if(ship != null){
            int healthLeft = ship.hit();
            boolean shipSunk = healthLeft == 0;

            return new HitResult(true, shipSunk, ship);
        }
        return new HitResult(false, false,null);
    }
}
