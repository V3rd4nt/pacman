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
    private int[] maxOcurrences;

    /**
     * Creates a new PillHandler
     */
    public PillHandler (ElementHandler eh) {
        pills = new ArrayList<>();
        this.eh = eh;
        setOcurrences();
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

    // TODO Changed
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
        int maxOcurrence, number;

        switch(elementType) {
            case "POWER":
                pill = new Pill(Pill.Type.POWER, pos);
                number = pill.getType().getNumber();
                maxOcurrence = maxOcurrences[number];
                break;
            default: return false;
        }
        if (maxOcurrence > 0) {
            pills.add(pill);
            maxOcurrences[number] = maxOcurrence-1;
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

    // TODO new
    private void setOcurrences () {
        int numberOfDifferentPills = 0;
        for (Pill.Type t : Pill.Type.values()) {
            numberOfDifferentPills++;
        }
        maxOcurrences = new int[numberOfDifferentPills];
        int i = 0;
        for (Pill.Type t : Pill.Type.values()) {
            maxOcurrences[i] = t.getMaxOcurrence();
        }
    }
}