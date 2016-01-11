package Pacman.Elements;

/**
 * Pill
 */
public class Pill extends Element {

    /**
     * Available pill types
     */
    public enum Type {
        POWER(10, 2);

        private int effectTime, maxOcurrence;

        Type(int effectTime, int maxOcurrence) {
            this.effectTime = effectTime;
            this.maxOcurrence = maxOcurrence;
        }

        /**
         * Returns the effect time of the pill
         * @return effect time
         */
        public int getEffectTime() {
            return effectTime;
        }

        /**
         * Returns the number of allowed ocurrences of the pill
         * @return maximum allowed occurences of a pill
         */
        public int getMaxOcurrence() {
            return maxOcurrence;
        }

        /**
         * Sets the number of allowed ocurrences of the pill
         * @param maxOcurrence maximum allowed occurences of a pill
         */
        public void setMaxOcurrence(int maxOcurrence) {
            this.maxOcurrence = maxOcurrence;
        }
    }


    private Type pillType;

    /**
     * Creates a new pill on specified position on the playing field
     * @param pillType  an enum pill type
     * @param pos       specified position
     */
    public Pill (Type pillType, Position pos) {

        super (pos);
        this.pillType = pillType;
    }

    /**
     * Returns the enum type of a pill
     * @return pill enum type
     */
    public Type getType() {
        return pillType;
    }

    /**
     * Returns the name of an enum pill type
     * @return pill enum name plus class name
     */
    @Override
    public String toString () {
        return pillType.toString() + " PILL";
    }
}