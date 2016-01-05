package Elements;

public class Corn extends Element {

    private int val;

    public Corn (Position pos) {
        super (pos);
        this.val = 10;
    }

    public int getValue () {
        return val;
    }

    public String toString () {
        return "Corn";
    }
}
