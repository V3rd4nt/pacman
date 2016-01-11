package Pacman.Elements;

import Pacman.Util.Messages;

/**
 * Abstract Element
 */
public abstract class Element {
    Position pos;

    /**
     * Creates a new element on a specified position on the playing field
     * @param pos specified position
     */
    public Element (Position pos) {
        this.pos = pos;
    }

    /**
     * Sets the position of the element on the playing field
     * @param pos specified position
     */
    public void setPosition (Position pos) {
        if (!(this instanceof Corn))
        Messages.position(this);
        this.pos = pos;
    }

    /**
     * Returns the position of the element
     * @return position of the element
     */
    public Position getPosition () {
        return pos;
    }

    /**
     * Returns the representation of the elemnt class
     * @return classname
     */
    public abstract String toString ();
}
