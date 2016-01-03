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

    public void createElement (String elementType1, String elementType2, Position pos) {
        if (pos == null) pos = randomPosition();
        switch (elementType1) {
            case "FRUIT":
                fruitHandler.create (elementType2, pos);
                break;
            case "PILL":
                pillHandler.create (elementType2, pos);
                break;
            default:
        }
    }

    public void createElement (String elementType1, Position pos) {
        switch (elementType1) {
            case "CORN":
                cornHandler.create(elementType1, pos);
                break;
            default:
        }
    }

    public Position randomPosition () {
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
