package Elements;

import java.util.ArrayList;
import java.util.List;

public class PillHandler implements ElementHandler {
    private List<Pill> pills;
    private static int numberOfGhotstLeft = 0;

    public PillHandler () {
        pills = new ArrayList<>();
    }

    @Override
    public boolean create (ElementType cType, Position pos) {
        Pill pill;

        switch(cType) {
            case POWER:
                pill = new Pill(Pill.PillType.POWER, pos);
                break;
            default: return false;
        }
        int maxOcurrence = pill.getPillType().getMaxOcurrence();
        if (maxOcurrence > 0) {
            pills.add(pill);
            pill.getPillType().setMaxOcurrence(maxOcurrence-1);
            return true;
        }
        return false;
    }

    @Override
    public boolean eat (Position pos) {
        for (Pill pill : pills) {
            if (pill.getPosition().getX() == pos.getX() && pill.getPosition().getY() == pos.getY()) {
                int effectTime = pill.getPillType().getEffectTime();
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

    private void startPillEffect (Pill pill, int effectTime) {
        pill.pillEffect (pill.getPillType(), effectTime);
    }
}