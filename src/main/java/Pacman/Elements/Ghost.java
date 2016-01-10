package Pacman.Elements;

public class Ghost extends Element {

    public enum Type {
        RED,
        BLUE,
        GREEN,
        YELLOW;

        private int val;

        Type() {
            val = 200;
        }

        public int getValue() {
            return val;
        }

    }
    private Type ghostType;


    public Ghost (Type ghostType, Position pos) {
        super (pos);
        this.ghostType = ghostType;
    }

    public Type getType () { return  ghostType; }

    @Override
    public String toString () {
        return ghostType.toString() + " GHOST";
    }
}