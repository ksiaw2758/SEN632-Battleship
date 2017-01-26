package systemoutgames;

public class Ship {

    private String name;
    private int health;
    private Location location;
    private int size;

    public Ship(String name, int startingHealth, Location location) {
        this.name = name;
        this.health = startingHealth;
        this.size = startingHealth;
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public int getSize() {
        return size;
    }
}
