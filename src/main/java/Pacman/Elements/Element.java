package Pacman.Elements;

import Pacman.Util.Messages;

/**
 * Abstract Element Class
 */
public abstract class Element {
    Position pos;

    /**
     * Creates a new Element on a specified Position on the playing field
     * @param pos specified position
     */
    public Element (Position pos) {
        this.pos = pos;
    }

    /**
     * Sets the Position of the Element on the playing field
     * @param pos specified position
     */
    public void setPosition (Position pos) {
        if (!(this instanceof Corn))
        Messages.position(this);
        this.pos = pos;
    }

    /**
     * Returns the Position of the Element
     * @return position of the element
     */
    public Position getPosition () {
        return pos;
    }

    /**
     * Returns the representation of the Element class as String
     * @return classname
     */
    public abstract String toString ();
}
