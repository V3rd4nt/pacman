package Elements;

public interface ElementHandler {

    boolean create (String type, Position pos);
    boolean eat (Position pos);
    int getNumberOfElements ();
}
