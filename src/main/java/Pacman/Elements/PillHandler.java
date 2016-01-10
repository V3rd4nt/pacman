package Pacman.Elements;

import Pacman.Util.Messages;
import Pacman.Util.EventTimer;

import java.util.ArrayList;
import java.util.List;

public class PillHandler implements ElementHandler {
    private List<Pill> pills;
    private Thread timer;
    private ElementHandler eh;

    public PillHandler (ElementHandler eh) {
        pills = new ArrayList<>();
        this.eh = eh;
    }

    @Override
    public boolean create() {
        return false;
    }

    @Override
    public boolean create(Position pos) {
        return false;
    }

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

    @Override
    public List<?> getElements() {
        return pills;
    }
}