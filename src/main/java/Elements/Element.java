package Elements;

public abstract class Element {
    Position pos;

    public Element (Position pos) { this.pos = pos; }
    public void setPosition (Position pos) { this.pos = pos; }
    public Position getPosition () { return pos; }
    public abstract String toString ();
}
