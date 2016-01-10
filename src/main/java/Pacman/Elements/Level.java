package Pacman.Elements;

import Pacman.Util.Messages;
import Pacman.Util.Movement;
import java.util.List;

public class Level {

    private static int score = 0;

    private ElementHandler fruitHandler, ghostHandler, pillHandler, cornHandler, wallHandler;
    private Lifes lifes;
    private Pacman pacman;

    public Level (Pacman pacman, Lifes lifes) {
        this.pacman = pacman;
        this.lifes = lifes;
        fruitHandler = new FruitHandler();
        ghostHandler = new GhostHandler(lifes, pacman);
        pillHandler = new PillHandler(ghostHandler);
        cornHandler = new CornHandler();
        wallHandler = new WallHandler();
        setWalls();
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
        else return cornHandler.eat(pos) || ghostHandler.eat(pos) || pillHandler.eat(pos);
    }

    public boolean setAllCorns () {
        for (int x = 0; x <= Position.getWIDTH(); x++) {
            for (int y = 0; y <= Position.getHEIGHT(); y++) {
                if (!((x == pacman.getPosition().getX() && y == pacman.getPosition().getY()) || isWall (x, y)))
                    createElement("CORN", new Position (x,y));
            }
        }
        return true;
    }

    public static void addScore (int points) {
        score += points;
        Messages.displayScore(score);
    }

    private boolean setWalls () {
        // wall 1 : Y-Direction
        for (int y = 10; y <= 17; y++) {
            createElement ("WALL", new Position(7, y));
        }
        // wall 2 : X-Direction
        for (int x = 13; x <= 24; x++) {
            createElement ("WALL", new Position(x, 11));
        }
        return true;
    }

    public boolean isWall (int x, int y) {
        for (Wall wall : (List<Wall>)wallHandler.getElements()) {
            if (wall.getPosition().getX() == x && wall.getPosition().getY() == y) {
                return true;
            }
        }
        return false;
    }

    public boolean isWall (Position pos) {
        return isWall (pos.getX(), pos.getY());
    }

    public int getScore () {
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
}
