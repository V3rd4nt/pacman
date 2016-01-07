package Elements;

public class Fruit extends Element {

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

        public int getValue() {
            return val;
        }

        public int getDisplayTime() {
            return displayTime;
        }
    }

    protected Type fruitType;

    public Fruit (Type fruitType, Position pos) {

        super(pos);
        this.fruitType = fruitType;
    }

    public Type getType () { return  fruitType; }

    @Override
    public String toString () {
        return fruitType.toString();
    }
}
