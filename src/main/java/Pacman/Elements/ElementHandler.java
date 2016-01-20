package Pacman.Elements;

import java.util.List;

/**
 * ElementHandler Class
 */
public interface ElementHandler {

    /**
     * Creates a new Element on the specified Position
     * @param elementType represents an enum Element type
     * @param pos specified position
     * @return true if successfully created, false if otherwise
     */
    boolean create (String elementType, Position pos);

    /**
     * Creates a new Element on the specified Position
     * @param pos specified position
     * @return true if successfully created, false if otherwise
     */
    boolean create (Position pos);

    /**
     * Creates a new Element
     * @return true if successfully created, false if otherwise
     */
    boolean create ();

    /**
     * Tries to remove an Element on the specified position
     * @param pos specified position
     * @return true if Element was removed, false if otherwise
     */
    boolean eat (Position pos);

    /**
     * Returns all available Elements
     * @return list of Fruits
     */
    List<?> getElements ();
}
