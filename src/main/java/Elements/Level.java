package Elements;

import Util.Messages;
import Util.Movement;
import java.util.ArrayList;
import java.util.List;

public class Level {

    private static int score = 0;

    private ElementHandler fruitHandler;
    private ElementHandler ghostHandler;
    private ElementHandler pillHandler;
    private ElementHandler cornHandler;
    private ElementHandler pacManhandler;

    private ElementHandler wallHandler;
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
        wallHandler = new WallHandler();
        this.setWalls();
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
            case "WALL": return wallHandler.create(pos);
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
        int x, y;
        x = 0;
        Position posCorn;
        while(x <= Position.getWIDTH()){
            y = 0;
            while (y <= Position.getHEIGHT()){
                posCorn = new Position(x, y);
                if (! (this.pacman.getPosition().compareTo(posCorn) == 0) && !isWall(posCorn)){
                    boolean corn = this.createElement("CORN", posCorn);
                }

                y++;
            }
            x++;
        }
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

    public ElementHandler getWallHandler() {
        return wallHandler;
    }

    private void setWalls(){
        int x, y;
        x = 0;
        y = 0;
        Position posWall;
        while(x <= Position.getWIDTH()){
            posWall = new Position(x, 0);
            boolean wall = this.createElement("WALL", posWall);
            posWall = new Position(x, Position.getHEIGHT());
            wall = this.createElement("WALL", posWall);
            x++;
        }
        while(y <= Position.getHEIGHT()){
            posWall = new Position(0, y);
            boolean wall = this.createElement("WALL", posWall);

            posWall = new Position(Position.getWIDTH(), y);
            wall = this.createElement("WALL", posWall);
            y++;
        }


    }

    public boolean isWall(Position pos){
        boolean isWall = false;
        for (Object wallItem : this.wallHandler.getElements()
                ) {
            if (wallItem instanceof Wall) {
                isWall = pos.compareTo(((Wall) wallItem).getPosition()) == 0;
                if (isWall) {
                    return isWall;
                }
            }
        }
        return  isWall;
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
