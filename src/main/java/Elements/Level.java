package Elements;

import Util.Messages;
import Util.Movement;
import java.util.ArrayList;
import java.util.List;

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
        boolean successful;
        if (pos == null) pos = Movement.createRandomPosition();
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
            case "PACMAN": if (pacManhandler.create(elementType1, pos)) return true;
            default: return false;
        }
    }

    public ElementHandler getFruitHandler() {
        return fruitHandler;
    }

    public ElementHandler getGhostHandler() {
        return ghostHandler;
    }

    public ElementHandler getPillHandler() {
        return pillHandler;
    }

    public ElementHandler getCornHandler() {
        return cornHandler;
    }

    public ElementHandler getPacManhandler() {
        return pacManhandler;
    }

    public List<ElementHandler> getEatableElementsHandler(){
        List<ElementHandler> listElemHandler = new ArrayList<ElementHandler>();
        listElemHandler.add(this.cornHandler);
        listElemHandler.add(this.pillHandler);
        listElemHandler.add(this.ghostHandler);
        listElemHandler.add(this.pillHandler);
        return  listElemHandler;
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
