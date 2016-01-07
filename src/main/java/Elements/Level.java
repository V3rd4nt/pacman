package Elements;

import Util.Messages;
import Util.Movement;
import java.util.ArrayList;
import java.util.List;

public class Level {

    private static int score = 0;

    private ElementHandler fruitHandler, ghostHandler, pillHandler, cornHandler, pacManhandler;
    private Lifes lifes;
    private Pacman pacman;

    public Level (Pacman pacman) {
        this.pacman = pacman;
        this.lifes = new Lifes(3);
        fruitHandler = new FruitHandler();
        ghostHandler = new GhostHandler(lifes, pacman);
        pillHandler = new PillHandler(ghostHandler);
        cornHandler = new CornHandler();
        pacManhandler = new PacmanHandler();
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
            default: return false;
        }
    }

    public boolean eat (Position pos) {
        if (fruitHandler.eat(pos)) {
            // fruit and corn on the same position
            cornHandler.eat(pos);
            return true;
        }
        else return cornHandler.eat(pos) || ghostHandler.eat(pos);
    }

    public void setAllCorns () {
        // TODO Fill playing field with corns, except positions of pills and starting position of pacman
    }

    public static void addScore (int points) {
        score += points;
        Messages.displayScore(score);
    }

    public static int getScore () {
        return score;
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

    public ElementHandler getCornHandler() {
        return cornHandler;
    }

    // TODO wird nicht gebraucht
    public ElementHandler getPillHandler() {
        return pillHandler;
    }

    // TODO wird nicht gebraucht
    public ElementHandler getPacManhandler() {
        return pacManhandler;
    }

    // TODO für was brauchst du diese methode?
    public List<ElementHandler> getEatableElementsHandler(){
        List<ElementHandler> listElemHandler = new ArrayList<ElementHandler>();
        listElemHandler.add(this.cornHandler);
        listElemHandler.add(this.pillHandler);
        listElemHandler.add(this.ghostHandler);
        listElemHandler.add(this.pillHandler);
        return  listElemHandler;
    }
}
