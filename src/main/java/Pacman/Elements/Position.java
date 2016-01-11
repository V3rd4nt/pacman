package Pacman.Elements;

/**
 * Position for Elements
 */
public class Position {

    private int x, y;

    // Level maximum size
    private static final int WIDTH = 30, HEIGHT = 20;

    /**
     * Creates a new position according to the specified coordinates
     * @param x x-coordinate
     * @param y y-coordinate
     */
    public Position (int x, int y) {
        if (x <= 0) this.x = 0;
        if (x > 0 && x < WIDTH) this.x = x;
        if (x >= WIDTH) this.x = WIDTH;
        if (y <= 0) this.y = 0;
        if (y > 0 && y < HEIGHT) this.y = y;
        if (y >= HEIGHT) this.y = HEIGHT;
    }

    /**
     * Returns the x-coordinate of the position
     * @return x-coordinate
     */
    public int getX () {
        return x;
    }

    /**
     * Returns the y-coordinate of the position
     * @return y-coordinate
     */
    public int getY () {
        return y;
    }

    /**
     * Sezs the x-coordinate of the position
     * @param x x-coordinate
     * @return true if successfully set, false otherwise
     */
    public boolean setX (int x) {

        if (x >= 0 && x <= WIDTH){
            this.x = x;
            return true;
        }
        return false;
    }

    /**
     * Sezs the y-coordinate of the position
     * @param y y-coordinate
     * @return true if successfully set, false otherwise
     */
    public boolean setY (int y) {
        if (y >= 0 && y <= HEIGHT){
            this.y = y;
            return true;
        }
        return false;
    }

    /**
     * Returns the coordinates of the position as String
     * @return position coordinates
     */
    @Override
    public String toString() {
        return "Position {" + "x = " + x + ", y = " + y + '}';
    }

    /**
     * Returns max. width of the playing field
     * @return max width
     */
    public static int getWIDTH() {
        return WIDTH;
    }

    /**
     * Returns max. height of the playing field
     * @return max height
     */
    public static int getHEIGHT() {
        return HEIGHT;
    }

    /**
     * Creates new position in the center of the playing field
     * @return new center position
     */
    public static Position getCenterPostition(){

        int x = WIDTH / 2;
        int y = HEIGHT / 2;
        return  new Position(x, y);
    }

    /**
     * Creates new starting position of pacman
     * @return new starting position
     */
    public static Position getStartingPos(){

        int x = WIDTH / 2;
        int y = (HEIGHT / 4) * 3;
        return  new Position(x, y);
    }
}
