package Elements;

import Util.Messages;
import Util.Movement;
import java.util.ArrayList;
import java.util.List;

public class Level {

    private static int score = 0;

    private ElementHandler fruitHandler, ghostHandler, pillHandler, cornHandler, pacManhandler;
    private Lifes lifes;

    public Level (Lifes lifes) {
        fruitHandler = new FruitHandler();
        ghostHandler = new GhostHandler(lifes);
        pillHandler = new PillHandler(ghostHandler);
        cornHandler = new CornHandler();
        pacManhandler = new PacmanHandler();
        this.lifes = lifes;
    }

    public boolean createElement (String elementType1, String elementType2, Position pos ) {
        if (pos == null) pos = Movement.createRandomPosition();
        switch (elementType1) {
            case "PILL": return pillHandler.create (elementType2, pos);
            default: return false;
        }
    }

    public boolean createElement (String elementType1, Position pos) {
        if (pos == null) pos = Movement.createRandomPosition();
        switch (elementType1) {
            case "CORN": return cornHandler.create(pos);
            case "GHOST": return ghostHandler.create(pos);
            case "FRUIT": return fruitHandler.create();

                // ich glaub elementtype kannst beim pacman entfernen
            case "PACMAN": return pacManhandler.create(elementType1, pos);

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

    public void setcorns () {

    }

    public static void addScore (int points) {
        score += points;

        Messages.displayScore(score);
    }

    public int getLifes () {
        return lifes.getAmount();
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
}
