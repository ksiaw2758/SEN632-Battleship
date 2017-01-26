package systemoutgames;

public class Location {

    private int x;
    private int y;
    private Direction direction;

    public Location(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Location(Character x, Character y, Direction direction) {
        this.x = getXValueFromString(x);
        this.y = Integer.parseInt(y.toString());
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    private int getXValueFromString(Character x) {
        char ch  = Character.toLowerCase(x);
            int temp = (int)ch;
            int temp_integer = 96;

            return temp - temp_integer;
    }
}
