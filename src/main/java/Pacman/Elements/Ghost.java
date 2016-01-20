package Pacman.Elements;

/**
 * Ghost Class
 */
public class Ghost extends Element {

    /**
     * Available Ghost types
     */
    public enum Type {
        RED,
        BLUE,
        GREEN,
        YELLOW;

        private int val;

        Type() {
            val = 200;
        }

        /**
         * Returns the points for an eaten Ghost
         * @return amount of points
         */
        public int getValue() {
            return val;
        }

    }
    private Type ghostType;

    /**
     * Creates a new Ghost on specified Position on the playing field
     * @param ghostType an enum ghost type
     * @param pos       specified position
     */
    public Ghost (Type ghostType, Position pos) {
        super (pos);
        this.ghostType = ghostType;
    }

    /**
     * Returns the enum type of a Ghost
     * @return ghost enum type
     */
    public Type getType () { return  ghostType; }

    /**
     * Returns the name of an enum Ghost type as String
     * @return ghost enum name plus class name
     */
    @Override
    public String toString () {
        return ghostType.toString() + " GHOST";
    }
}