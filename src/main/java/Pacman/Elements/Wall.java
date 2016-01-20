package Pacman.Elements;

/**
 * Wall Class
 */
public class Wall extends Element {

    /**
     * Creates a new Wall on a specified Position on the playing field
     * @param pos specified position
     */
    public Wall(Position pos) {
        super(pos);
    }

    /**
     * Returns the representation of the Wall class as String
     * @return classname
     */
    @Override
    public String toString() {
        return "WALL";
    }
}
