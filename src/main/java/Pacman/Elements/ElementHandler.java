package Pacman.Elements;

import java.util.List;

public interface ElementHandler {

    boolean create (String elementType, Position pos);
    boolean create (Position pos);
    boolean create ();

    boolean eat (Position pos);
    List<?> getElements ();
}
