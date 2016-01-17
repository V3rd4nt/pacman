package Pacman.Elements;

import Pacman.Util.Messages;
import Pacman.Util.Movement;
import java.util.List;

/**
 * Level Class
 */
public class Level {

    private static int score = 0;

    private ElementHandler fruitHandler, ghostHandler, pillHandler, cornHandler, wallHandler;
    private Lifes lifes;
    private Pacman pacman;

    /**
     * Creates a new Level
     * @param pacman pacman object
     * @param lifes level object with already set amount of lifes
     */
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

    /**
     * Creates a new Element on a specified position on the playing field
     * @param elementType1 represents an enum Element type
     * @param elementType2 represents an enum Element type
     * @param pos specified position
     * @return true if successfully created, false if otherwise
     */
    public boolean createElement (String elementType1, String elementType2, Position pos ) {
        if (pos == null) pos = Movement.createRandomPosition();
        switch (elementType1) {
            case "PILL": return pillHandler.create (elementType2, pos);
            default: return false;
        }
    }

    /**
     * Creates a new Element on a specified position on the playing field
     * @param elementType1 represents an enum Element type
     * @param pos specified position
     * @return true if successfully created, false if otherwise
     */
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

    // TODO Changed
    /**
     * Tries to remove an Element on the specified position
     * @param pos specified position
     * @return true if Element was removed, false if otherwise
     */
    public boolean eat (Position pos) {
        if (fruitHandler.eat(pos)) {
            // fruit and corn on the same position
            cornHandler.eat(pos);
            return true;
        }
        if (cornHandler.eat(pos)) return true;
        if (ghostHandler.eat(pos)) return true;
        if (pillHandler.eat(pos)) return true;
        return false;
    }

    /**
     * Creates all Corns on the playing field
     */
    public void setAllCorns () {
        for (int x = 0; x <= Position.getWIDTH(); x++) {
            for (int y = 0; y <= Position.getHEIGHT(); y++) {
                if (!((x == pacman.getPosition().getX() && y == pacman.getPosition().getY()) || isWall (x, y)))
                    createElement("CORN", new Position (x,y));
            }
        }
    }

    /**
     * Adds points to the overall game Score
     * @param points points to add
     */
    public static void addScore (int points) {
        score += points;
        Messages.displayScore(score);
    }

    /**
     * Sets 2 predefined walls
     */
    private void setWalls () {
        // wall 1 : Y-Direction
        for (int y = 10; y <= 17; y++) {
            createElement ("WALL", new Position(7, y));
        }
        // wall 2 : X-Direction
        for (int x = 13; x <= 24; x++) {
            createElement ("WALL", new Position(x, 11));
        }
    }

    /**
     * Checks if a Wall exists on the specified coordinates
     * @param x x-coordinate
     * @param y y-coordinate
     * @return true if wall exists on the specified coordinates, false if otherwise
     */
    public boolean isWall (int x, int y) {
        for (Wall wall : (List<Wall>)wallHandler.getElements()) {
            if (wall.getPosition().getX() == x && wall.getPosition().getY() == y) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a Wall exists on the specified Position
     * @param pos specified position
     * @return true if wall exists on the specified position, false if otherwise
     */
    public boolean isWall (Position pos) {
        return isWall (pos.getX(), pos.getY());
    }

    /**
     * Returns current game score
     * @return game score
     */
    public int getScore () {
        return score;
    }

    /**
     * Returns the amount of lifes left
     * @return lifes left
     */
    public int getLifes () {
        return lifes.getAmount();
    }

    /**
     * Returns the FruitHandler
     * @return ElementHandler
     */
    public ElementHandler getFruitHandler() {
        return fruitHandler;
    }

    /**
     * Returns the GhostHandler
     * @return ElementHandler
     */
    public ElementHandler getGhostHandler() {
        return ghostHandler;
    }

    /**
     * Returns the CornHandler
     * @return ElementHandler
     */
    public ElementHandler getCornHandler() {
        return cornHandler;
    }

    /**
     * Returns the PillHandler
     * @return ElementHandler
     */
    public ElementHandler getPillHandler() {
        return pillHandler;
    }
}
