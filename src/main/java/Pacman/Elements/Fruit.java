package Pacman.Elements;

/**
 * Fruit
 */
public class Fruit extends Element {

    /**
     * Available fruit types
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
         * Returns the points for an eaten fruit
         * @return amount of points
         */
        public int getValue() {
            return val;
        }

        /**
         * Returns the display time of the fruit
         * @return display time
         */
        public int getDisplayTime() {
            return displayTime;
        }
    }

    protected Type fruitType;

    /**
     * Creates a new fruit on specified position on the playing field
     * @param fruitType an enum fruit type
     * @param pos       specified position
     */
    public Fruit (Type fruitType, Position pos) {

        super(pos);
        this.fruitType = fruitType;
    }

    /**
     * Returns the enum type of a fruit
     * @return fruit enum type
     */
    public Type getType () { return  fruitType; }

    /**
     * Returns the name of an enum fruit type
     * @return fruit enum name
     */
    @Override
    public String toString () {
        return fruitType.toString();
    }
}
