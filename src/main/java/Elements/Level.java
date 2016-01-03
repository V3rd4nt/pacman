package Elements;

public class Level {

    private static int score = 0, highscore = 0;
    private ElementHandler fruitHandler, pillHandler, cornHandler;
    private Lifes lifes;

    public Level () {
        fruitHandler = new FruitHandler();
        pillHandler = new PillHandler();
        cornHandler = new CornHandler();
        lifes = new Lifes (3);
    }

    public void createCtype (ElementType cType1, ElementType cType2, Position pos) {
        if (pos == null) pos = randomPosition();
        switch (cType1) {
            case FRUIT:
                fruitHandler.create (cType2, pos);
                break;
            case PILL:
                pillHandler.create (cType2, pos);
                break;
            default:
        }
    }

    public void createCtype (ElementType cType1, Position pos) {
        switch (cType1) {
            case CORN:
                cornHandler.create(cType1, pos);
                break;
            default:
        }
    }

    protected static Position randomPosition () {
        // implement random positioning
        return new Position (1, 1);
    }

    public static void addScore (int points) {
        score += points;
    }

    protected void resetGame () {
        highscore = score;
        score = 0;
        fruitHandler = new FruitHandler();
        pillHandler = new PillHandler();
        cornHandler = new CornHandler();
        lifes = new Lifes (3);
    }
}
