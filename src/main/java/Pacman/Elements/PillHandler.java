package Pacman.Elements;

import Pacman.Util.Messages;
import Pacman.Util.EventTimer;

import java.util.ArrayList;
import java.util.List;

/**
 * PillHandler Class
 */
public class PillHandler implements ElementHandler {
    private List<Pill> pills;
    private Thread timer;
    private ElementHandler eh;

    /**
     * Creates a new PillHandler
     */
    public PillHandler (ElementHandler eh) {
        pills = new ArrayList<>();
        this.eh = eh;
    }

    /**
     * Not implemented: use create (String elementType, Position pos)
     */
    @Override
    public boolean create() {
        return false;
    }

    /**
     * Not implemented: use create (String elementType, Position pos)
     */
    @Override
    public boolean create(Position pos) {
        return false;
    }

    /**
     * Creates a new Pill on the specified Position
     * (Not allowed to create more Pills than defined maximum occurrence)
     * @param elementType represents an enum Element type
     * @param pos specified position
     * @return true if successfully created, false if otherwise
     */
    @Override
    public boolean create (String elementType, Position pos) {
        Pill pill;

        switch(elementType) {
            case "POWER":
                pill = new Pill(Pill.Type.POWER, pos);
                break;
            default: return false;
        }
        int maxOcurrence = pill.getType().getMaxOcurrence();
        if (maxOcurrence > 0) {
            pills.add(pill);
            pill.getType().setMaxOcurrence(maxOcurrence-1);

            Messages.appear(pill);

            return true;
        }
        return false;
    }

    /**
     * Tries to remove a Pill on the specified position
     * (Creates and starts a new EventTimer Thread)
     * @param pos specified position
     * @return true if Fruit was removed, false if otherwise
     */
    @Override
    public boolean eat (Position pos) {
        for (Pill pill : pills) {
            if (pill.getPosition().getX() == pos.getX() && pill.getPosition().getY() == pos.getY()) {
                int effectTime = pill.getType().getEffectTime();
                timer = new EventTimer(effectTime, this, eh, pill);
                timer.start();
                pills.remove(pill);
                return true;
            }
        }
        return false;
    }

    /**
     * Returns all available Pills
     * @return list of Pills
     */
    @Override
    public List<?> getElements() {
        return pills;
    }
}