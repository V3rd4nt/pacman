package Pacman.Elements;

/**
 * Pill Class
 */
public class Pill extends Element {

    /**
     * Available Pill types
     */
    public enum Type {
        POWER(10, 2);

        private int effectTime, maxOcurrence;

        Type(int effectTime, int maxOcurrence) {
            this.effectTime = effectTime;
            this.maxOcurrence = maxOcurrence;
        }

        /**
         * Returns the effect time of the Pill
         * @return effect time
         */
        public int getEffectTime() {
            return effectTime;
        }

        /**
         * Returns the number of allowed ocurrences of the Pill
         * @return maximum allowed occurences
         */
        public int getMaxOcurrence() {
            return maxOcurrence;
        }

        /**
         * Sets the number of allowed ocurrences of the Pill
         * @param maxOcurrence maximum allowed occurences
         */
        public void setMaxOcurrence(int maxOcurrence) {
            this.maxOcurrence = maxOcurrence;
        }
    }


    private Type pillType;

    /**
     * Creates a new Pill on specified Position on the playing field
     * @param pillType  an enum pill type
     * @param pos       specified position
     */
    public Pill (Type pillType, Position pos) {

        super (pos);
        this.pillType = pillType;
    }

    /**
     * Returns the enum type of a Pill
     * @return pill enum type
     */
    public Type getType() {
        return pillType;
    }

    /**
     * Returns the name of an enum Pill type as String
     * @return pill enum name plus class name
     */
    @Override
    public String toString () {
        return pillType.toString() + " PILL";
    }
}