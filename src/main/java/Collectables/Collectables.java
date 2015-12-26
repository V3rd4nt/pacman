package Collectables;

/**
 * Created by armor on 25.12.2015.
 */
public class Collectables {

    private static int score = 0, highscore = 0;

    CollectablesHandler fruitHandler, pillHandler, cornHandler;

    public Collectables () {
        fruitHandler = new FruitHandler();
        pillHandler = new PillHandler();
        cornHandler = new CornHandler();
    }

    public void createCtype (CollectableType cType1, CollectableType cType2, Position pos) {
        switch (cType2) {
            case FRUIT:
                fruitHandler.create (cType1, randomPosition());
                break;
            case PILL:
                pillHandler.create (cType1, pos);
                break;
            case CORN:
                cornHandler.create(cType1, pos);
                break;
            default:
        }
    }

    private Position randomPosition () {
        // implement random positioning
        return new Position (1, 1);
    }

    public static void addScore (int points) {
        score += points;
    }

    public void resetGame () {
        highscore = score;
        score = 0;
        fruitHandler = new FruitHandler();
        pillHandler = new PillHandler();
        cornHandler = new CornHandler();
    }

}
