package Pacman.Elements;

import Pacman.Util.Messages;
import java.util.ArrayList;
import java.util.List;

/**
 * CornHandler Class
 */
public class CornHandler implements ElementHandler {
    List<Corn> corns;

    /**
     * Creates a new CornHandler
     */
    public CornHandler() {
        corns = new ArrayList<>();
    }

    /**
     * Not implemented: use create (Position pos)
     */
    @Override
    public boolean create() {
        return false;
    }

    /**
     * Creates a new Corn on the specified Position
     * @param pos specified position
     * @return true if successfully created, false if otherwise
     */
    @Override
    public boolean create(Position pos) {
        Corn corn = new Corn(pos);
        corns.add(corn);
        return true;
    }

    /**
     * Not implemented: use create (Position pos)
     */
    @Override
    public boolean create (String elementType, Position pos) {
        return false;
    }

    /**
     * Tries to remove a Corn on the specified position
     * @param pos specified position
     * @return true if Corn was removed, false if otherwise
     */
    @Override
    public boolean eat (Position pos) {
        for (Corn corn : corns) {
            if (corn.getPosition().getX() == pos.getX() && corn.getPosition().getY() == pos.getY()) {
                getPoints(corn);
                corns.remove(corn);
                Messages.pacmanEat(corn);
                return true;
            }
        }
        return false;
    }

    /**
     * Returns all available Corns
     * @return list of Corns
     */
    @Override
    public List<?> getElements() {
        return corns;
    }

    private void getPoints (Corn corn) {
        Level.addScore(corn.getValue());
    }
}
