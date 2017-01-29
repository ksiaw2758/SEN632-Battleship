package systemoutgames;

public class HitResult {

    private boolean shipHit;
    private boolean shipSunk;
    private String sunkShipName;
    private boolean gameOver;

    public HitResult(boolean shipHit, boolean shipSunk, String sunkShipName, boolean gameOver) {
        this.shipHit = shipHit;
        this.shipSunk = shipSunk;
        this.sunkShipName = sunkShipName;
        this.gameOver = gameOver;
    }

    public String getSunkShipName() {
        return sunkShipName;
    }

    public boolean isShipHit() {
        return shipHit;
    }

    public boolean isShipSunk() {
        return shipSunk;
    }

    public boolean isGameOver() {
        return gameOver;
    }
}
