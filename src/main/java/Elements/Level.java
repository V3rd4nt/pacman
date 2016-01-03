package Elements;

import Util.Messages;

public class Level {

    private static int score = 0, highscore = 0;
    private ElementHandler fruitHandler, ghostHandler, pillHandler, cornHandler;
    private Lifes lifes;

    public Level () {
        fruitHandler = new FruitHandler();
        ghostHandler = new GhostHandler();
        pillHandler = new PillHandler(ghostHandler);
        cornHandler = new CornHandler();
        lifes = new Lifes (3);
    }

    public boolean createElement (String elementType1, String elementType2, Position pos ) {
        boolean successful;
        if (pos == null) pos = randomPosition();
        switch (elementType1) {
            case "FRUIT": if (fruitHandler.create (elementType2, pos)) return true;
            case "PILL": if (pillHandler.create (elementType2, pos)) return true;
            case "GHOST": if (ghostHandler.create(elementType2, pos)) return true;
            default: return false;
        }
    }

    public boolean createElement (String elementType1, Position pos) {
        switch (elementType1) {
            case "CORN": if (cornHandler.create(elementType1, pos)) return true;
            default: return false;
        }
    }

    public boolean eat (Position pos) {
        if (fruitHandler.eat(pos)) {
            // fruit and corn on the same position
            cornHandler.eat(pos);
            return true;
        }
        else return pillHandler.eat(pos) || cornHandler.eat(pos) || ghostHandler.eat(pos);
    }

    public Position randomPosition () {
        // implement random positioning
        return new Position (1, 1);
    }

    public static void addScore (int points) {
        score += points;

        Messages.displayScore(score);
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
