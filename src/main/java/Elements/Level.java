package Elements;

/**
 * Created by Peter on 25.12.2015.
 */
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
        switch (cType2) {
            case FRUIT:
                fruitHandler.create (cType1, randomPosition());
                break;
            case PILL:
                pillHandler.create (cType1, pos);
                break;
            case CORN:
                cornHandler.create(cType2, pos);
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
