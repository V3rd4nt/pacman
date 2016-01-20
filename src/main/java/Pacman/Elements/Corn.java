package Pacman.Elements;

/**
 * Corn Class
 */
public class Corn extends Element {

    private int val;

    /**
     * Creates a new Corn on a specified Position on the playing field
     * @param pos specified position
     */
    public Corn (Position pos) {
        super (pos);
        this.val = 10;
    }

    /**
     * Returns the points for an eaten Corn
     * @return amount of points
     */
    public int getValue () {
        return val;
    }

    /**
     * Returns the representation of the Corn class as String
     * @return classname
     */
    public String toString () {
        return "CORN";
    }
}
