import Elements.*;
import Util.*;

public class MainTest {
    public static Position pos (int x, int y) {
        return new Position (x, y);
    }

    public static void main (String[] args) {

        // TESTING ONLY

        // level size see Position class
        Level level = new Level (new Lifes (3));

        // ghost creation
        level.createElement("GHOST", Position.getCenterPostition());
        level.createElement("GHOST", Position.getCenterPostition());
        level.createElement("GHOST", Position.getCenterPostition());
        level.createElement("GHOST", Position.getCenterPostition());
        level.createElement ("CORN", pos (15,14));
        level.createElement ("CORN", pos (14,15));
        // placement of power pill
        level.createElement("PILL", "POWER", pos (15,16));
        level.createElement("PACMAN", Position.getStartingPos());
        ElementHandler elem = level.getPacManhandler();
        if (elem instanceof PacmanHandler){
            PacmanHandler pacmanHandler = (PacmanHandler) elem;
            Pacman pacman = ((Pacman) pacmanHandler.getElements().get(0));
            if (pacman != null){
                pacmanHandler.move();
                for (ElementHandler elemHandler:level.getEatableElementsHandler()
                        ) {
                    pacmanHandler.eat(elemHandler);
                }
            }

        }
    }
}
