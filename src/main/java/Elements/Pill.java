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

    public Position getPosition() {
        return pos;
    }

    protected Type getType() {
        return pillType;
    }

    public String toString () {
        return pillType.toString() + " PILL";
    }

    protected void pillEffect(Type pillType, int effectTime) {

        // implement power pill effect
        switch (pillType) {
            case POWER: {
                // ghosts are vulnerable

                // active pill timer

                // getPoints(numberOfGhostsLeft);
            }
            default:
        }
    }

    protected void getPoints(int numberOfGhostsLeft) {
        int score = 0;
        switch (numberOfGhostsLeft) {
            case 3:
                score = 200;
                break;
            case 2:
                score = 400;
                break;
            case 1:
                score = 800;
                break;
            case 0:
                score = 1600;
                break;
            default:
        }
        Level.addScore(score);
    }
}