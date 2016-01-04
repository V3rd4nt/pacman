package Elements;

public class Pill extends Element {

    public enum Type {
        POWER(10, 2);

        private int effectTime, maxOcurrence;

        Type(int effectTime, int maxOcurrence) {
            this.effectTime = effectTime;
            this.maxOcurrence = maxOcurrence;
        }

        public int getEffectTime() {
            return effectTime;
        }

        public int getMaxOcurrence() {
            return maxOcurrence;
        }

        public void setMaxOcurrence(int maxOcurrence) {
            this.maxOcurrence = maxOcurrence;
        }
    }


    private Type pillType;

    public Pill (Type pillType, Position pos) {

        super (pos);
        this.pillType = pillType;
    }

    public Type getType() {
        return pillType;
    }

    public String toString () {
        return pillType.toString() + " Pill";
    }
}