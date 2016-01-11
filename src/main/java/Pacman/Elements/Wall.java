package Pacman.Elements;

/**
 * Wall
 */
public class Wall extends Element {

    /**
     * Creates a new wall on a specified position on the playing field
     * @param pos specified position
     */
    public Wall(Position pos) {
        super(pos);
    }

    /**
     * Returns the representation of the wall class
     * @return classname
     */
    @Override
    public String toString() {
        return "WALL";
    }
}
