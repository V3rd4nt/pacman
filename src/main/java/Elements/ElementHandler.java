package Elements;

import java.util.List;

public abstract class ElementHandler {

    public abstract boolean create (String type, Position pos);
    public abstract boolean eat (Position pos);
    public abstract int getNumberOfElements ();
    public abstract List<?> getElements ();
}
