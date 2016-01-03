package Elements;

import Util.Messages;

import java.util.ArrayList;
import java.util.List;

public class PillHandler extends ElementHandler {
    private List<Pill> pills;

    public PillHandler () {
        pills = new ArrayList<>();
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
                startPillEffect(pill, effectTime);
                pills.remove(pill);
                return true;
            }
        }
        return false;
    }

    @Override
    public int getNumberOfElements() {
        return pills.size();
    }

    @Override
    public List<?> getElements() {
        return pills;
    }

    private void startPillEffect (Pill pill, int effectTime) {
        pill.pillEffect (pill.getType(), effectTime);
    }
}