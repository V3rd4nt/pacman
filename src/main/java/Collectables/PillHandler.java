package Collectables;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by armor on 25.12.2015.
 */
public class PillHandler implements CollectablesHandler {
    List<Pill> pills;

    public PillHandler () {
        pills = new ArrayList<Pill>();
    }

    public boolean create (CollectableType cType, Position pos) {
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

    public boolean eat (Position pos) {
        int effectTime = 0;
        for (Pill pill : pills) {
            if (pill.getPosition().getX() == pos.getX() && pill.getPosition().getY() == pos.getY()) {
                effectTime = pill.getPillType().getEffectTime();
                startPillEffect(pill, effectTime);
                pills.remove(pill);
                return true;
            }
        }
        return false;
    }

    private void startPillEffect (Pill pill, int effectTime) {
        pill.pillEffect(pill.getPillType(), effectTime);
    }
}