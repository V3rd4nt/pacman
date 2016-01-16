package Pacman.Elements;

/**
 * Pill Class
 */
public class Pill extends Element {

    // TODO Number added
    /**
     * Available Pill types
     */
    public enum Type {
        POWER(10, 2, 0);

        private int effectTime, maxOcurrence, number;

        Type(int effectTime, int maxOcurrence, int number) {
            this.effectTime = effectTime;
            this.maxOcurrence = maxOcurrence;
            this.number = number;
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

        // TODO new
        public int getNumber () {
            return number;
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