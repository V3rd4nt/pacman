package Elements;

/**
 * Created by Peter on 26.12.2015.
 */
public interface ElementHandler {

    boolean create (ElementType cType, Position pos);
    boolean eat (Position pos);
    int getNumberOfElements ();
}
