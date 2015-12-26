package Collectables;

/**
 * Created by armor on 25.12.2015.
 */
public class Pill {

    public enum PillType {
        POWER(10, 2);

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

        public void setMaxOcurrence (int maxOcurrence) {
            this.maxOcurrence = maxOcurrence;
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

    public PillType getPillType() { return pillType; }

    public void pillEffect (PillType pillType, int effectTime) {

        // implement power pill effect
        switch(pillType) {
            case POWER: {

            }
            default:
        }
    }
}
