package Pacman.Elements;

/**
 * Fruit Class
 */
public class Fruit extends Element {

    /**
     * Available Fruit types
     */
    public enum Type {
        CHERRY(200, 5),
        APPLE(400, 5),
        STRAWBERRY(800, 4),
        PEACH(1600, 4),
        BANANA(3200, 3);
        private int val, displayTime;

        Type (int val, int displayTime) {
            this.val = val;
            this.displayTime = displayTime;
        }

        /**
         * Returns the points for an eaten Fruit
         * @return amount of points
         */
        public int getValue() {
            return val;
        }

        /**
         * Returns the display time of the Fruit
         * @return display time
         */
        public int getDisplayTime() {
            return displayTime;
        }
    }

    protected Type fruitType;

    /**
     * Creates a new Fruit on specified Position on the playing field
     * @param fruitType enum fruit type
     * @param pos       specified position
     */
    public Fruit (Type fruitType, Position pos) {

        super(pos);
        this.fruitType = fruitType;
    }

    /**
     * Returns the enum type of a Fruit
     * @return fruit enum type
     */
    public Type getType () { return  fruitType; }

    /**
     * Returns the name of an enum Fruit type as String
     * @return fruit enum name
     */
    @Override
    public String toString () {
        return fruitType.toString();
    }
}
