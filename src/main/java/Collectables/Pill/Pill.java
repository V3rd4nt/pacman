package Collectables.Pill;

import Collectables.Position;

/**
 * Created by armor on 25.12.2015.
 */
public class Pill {

    public enum PillType {
        POWER(10, 2),
        BLACK(15, 1),
        GHOST(30, 1),
        LIFE(0, 1),
        DOUBLE(10, 2),
        GOD(15, 2),
        TUNNEL(5, 1);
        private int effectTime, maxOcurrence;

        private PillType(int effectTime, int maxOcurrence) {
            this.effectTime = effectTime;
            this.maxOcurrence = maxOcurrence;
        }

        public int getEffectTime() {
            return effectTime;
        }

        public int getMaxOcurrence() {
            return maxOcurrence;
        }
    }


    private PillType pillType;
    private Position pos;

    public Pill(PillType pillType, Position pos) {

        this.pillType = pillType;
        this.pos = pos;
    }

    public Position getPosition() {
        return pos;
    }

    public PillType getPillType() {
        return pillType;
    }
}
