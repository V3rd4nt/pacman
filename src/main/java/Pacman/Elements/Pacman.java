package Pacman.Elements;

/**
 * Pacman Class
 */
public class Pacman extends Element {

    /**
     * Creates a new Pacman on a specified Position on the playing field
     * @param pos specified position
     */
    public Pacman(Position pos) {
        super(pos);
    }

    /**
     * Returns the representation of the Pacman class as String
     * @return classname
     */
    @Override
    public String toString() {
        return "PACMAN";
    }
}