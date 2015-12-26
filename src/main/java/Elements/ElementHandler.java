package Elements;

public interface ElementHandler {

    boolean create (ElementType cType, Position pos);
    boolean eat (Position pos);
    int getNumberOfElements ();
}
