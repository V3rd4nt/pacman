package Elements;

import Util.Messages;
import Util.Movement;

public class Level {

    private static int score = 0, highscore = 0;
    private ElementHandler fruitHandler, ghostHandler, pillHandler, cornHandler, pacManhandler;
    private Lifes lifes;

    public Level () {
        fruitHandler = new FruitHandler();
        ghostHandler = new GhostHandler();
        pillHandler = new PillHandler(ghostHandler);
        cornHandler = new CornHandler();
        pacManhandler = new PacmanHandler();
        lifes = new Lifes (3);
    }

    public boolean createElement (String elementType1, String elementType2, Position pos ) {
        if (pos == null) pos = Movement.createRandomPosition();
        switch (elementType1) {
            case "PILL": if (pillHandler.create (elementType2, pos)) return true;
            default: return false;
        }
    }

    public boolean createElement (String elementType1, Position pos) {
        if (pos == null) pos = Movement.createRandomPosition();
        switch (elementType1) {
            case "CORN": if (cornHandler.create(pos)) return true;
            case "PACMAN": if (pacManhandler.create(pos)) return true;
            case "GHOST": if (ghostHandler.create(pos)) return true;
            default: return false;
        }
    }

    public ElementHandler getElementHandler (String elementType){
        switch (elementType) {
            case "PACMAN": return pacManhandler;
            case "FRUIT": return fruitHandler;
            case "PILL": return pillHandler;
            case "CORN": return cornHandler;
            default: return null;
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

    public static void addScore (int points) {
        score += points;

        Messages.displayScore(score);
    }

    public int getLifes () {
        return lifes.getAmount();
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
