package Pacman.Elements;

/**
 * Pacman
 */
public class Pacman extends Element {

    /**
     * Creates a new pacman on a specified position on the playing field
     * @param pos specified position
     */
    public Pacman(Position pos) {
        super(pos);
    }

    /**
     * Returns the representation of the pacman class
     * @return classname
     */
    @Override
    public String toString() {
        return "PACMAN";
    }
}