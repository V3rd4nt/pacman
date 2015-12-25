package Collectables.Pill;

import Collectables.CollectableType;
import Collectables.CollectablesHandler;
import Collectables.Position;

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

    public int createCtype(CollectableType cType, Position pos) {
        Pill pill;
        switch(cType) {
            case POWER:
                pill = new Pill(Pill.PillType.POWER, pos);
                break;
            case BLACK:
                pill = new Pill(Pill.PillType.BLACK, pos);
                break;
            case GHOST:
                pill = new Pill(Pill.PillType.GHOST, pos);
                break;
            case LIFE:
                pill = new Pill(Pill.PillType.LIFE, pos);
                break;
            case DOUBLE:
                pill = new Pill(Pill.PillType.DOUBLE, pos);
                break;
            case GOD:
                pill = new Pill(Pill.PillType.GOD, pos);
                break;
            case TUNNEL:
                pill = new Pill(Pill.PillType.TUNNEL, pos);
                break;
            default: return 0;
        }
        pills.add(pill);
        return pill.getPillType().getEffectTime();
    }

    public boolean delete (Position pos) {
        for (Pill pill : pills) {
            if (pill.getPosition().getX() == pos.getX() && pill.getPosition().getY() == pos.getY()) {
                pills.remove(pill);
                return true;
            }
        }
        return false;
    }

    public int getPoints (Position pos) {
        return 0;
    }

    public int getMaxOcurrence (Position pos) {
        int maxOcurrence = 0;
        for (Pill pill : pills) {
            if (pill.getPosition().getX() == pos.getX() && pill.getPosition().getY() == pos.getY()) {
                maxOcurrence = pill.getPillType().getMaxOcurrence();
            }
        }
        return maxOcurrence;
    }
}