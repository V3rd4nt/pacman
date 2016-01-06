package Elements;

import java.util.List;

public abstract class ElementHandler {

    public abstract boolean create (String elementType, Position pos);
    public abstract boolean create (Position pos);
    public abstract boolean create ();

    public abstract boolean eat (Position pos);
    public abstract int getNumberOfElements ();
    public abstract List<?> getElements ();
}
