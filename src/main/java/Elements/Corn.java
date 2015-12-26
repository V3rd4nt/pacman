package Elements;

public class Corn {

    private Position pos;
    private int val;

    public Corn (Position pos) {
        this.pos = pos;
        this.val = 10;
    }

    public Position getPosition () {
        return pos;
    }

    public int getValue () { return val; }
}
