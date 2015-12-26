package Elements;

/**
 * Created by Peter on 25.12.2015.
 */
public class Fruit {

    public enum FruitType {
        CHERRY(200, 5),
        APPLE(400, 5),
        STRAWBERRY(800, 4),
        PEACH(1600, 4),
        BANANA(3200, 3);
        private int val, displayTime;

        FruitType(int val, int displayTime) {
            this.val = val;
            this.displayTime = displayTime;
        }

        public int getValue() {
            return val;
        }

        public int getDisplayTime() {
            return displayTime;
        }
    }

    private FruitType fruitType;
    private Position pos;

    public Fruit (FruitType fruitType, Position pos) {

        this.fruitType = fruitType;
        this.pos = pos;
    }

    public Position getPosition () {
        return pos;
    }

    public FruitType getFruitType () { return  fruitType; }
}
