package Elements;

public class Ghost extends Element {

    public enum Type {
        RED(1),
        BLUE(2),
        GREEN(3),
        YELLOW(4);

        private int color, val;

        Type(int color) {
            this.color=color;
            val = 200;
        }

        public int getValue() {
            return val;
        }

        public int getColor() {
            return color;
        }
    }
    private Type ghostType;


    public Ghost (Type ghostType, Position pos) {
        super (pos);
        this.ghostType = ghostType;
    }

    public Type getType () { return  ghostType; }

    public String toString () {
        return ghostType.toString() + " GHOST";
    }
}