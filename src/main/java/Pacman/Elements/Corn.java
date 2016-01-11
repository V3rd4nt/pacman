package Pacman.Elements;

/**
 * Corn
 */
public class Corn extends Element {

    private int val;

    /**
     * Creates a new corn on a specified position on the playing field
     * @param pos specified position
     */
    public Corn (Position pos) {
        super (pos);
        this.val = 10;
    }

    /**
     * Returns the points for an eaten corn
     * @return amount of points
     */
    public int getValue () {
        return val;
    }

    /**
     * Retuns the representation of the corn class
     * @return classname
     */
    public String toString () {
        return "CORN";
    }
}
