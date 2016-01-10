package Pacman.Elements;

import Pacman.Elements.Pacman;

import Pacman.Util.Messages;

public abstract class Element {
    Position pos;

    public Element (Position pos) {
        this.pos = pos;
    }

    public void setPosition (Position pos) {
        if (!(this instanceof Corn))
        Messages.position(this);
        this.pos = pos;
    }

    public Position getPosition () {
        return pos;
    }

    public abstract String toString ();
}
