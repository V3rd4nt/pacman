package Elements;

public class Pill {

    public enum PillType {
        POWER(10, 2);

        private int effectTime, maxOcurrence;

        PillType(int effectTime, int maxOcurrence) {
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


    private PillType pillType;
    private Position pos;
    private int numberOfGhostsLeft = 4;

    public Pill(PillType pillType, Position pos) {

        this.pillType = pillType;
        this.pos = pos;
    }

    public Position getPosition() {
        return pos;
    }

    public void setNumberOfGhostsLeft (int numberOfGhostsLeft) {
        this.numberOfGhostsLeft = numberOfGhostsLeft;
    }

    public PillType getPillType() {
        return pillType;
    }

    protected void pillEffect(PillType pillType, int effectTime) {

        // implement power pill effect
        switch (pillType) {
            case POWER: {
                // ghosts are vulnerable

                // active pill timer

                getPoints(numberOfGhostsLeft);
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