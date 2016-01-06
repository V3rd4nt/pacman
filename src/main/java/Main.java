import Elements.*;
import Util.*;

public class Main {
    public static Position pos (int x, int y) {
        return new Position (x, y);
    }

    public static void main (String[] args) {

        //Game game = new Game ();
        //game.start();


        // TESTING ONLY

        // level size see Position class
        Level level = new Level ();

        // ghost creation
        level.createElement("GHOST", "RED", pos (6,1));
        level.createElement("GHOST", "BLUE", pos (6,2));
        level.createElement("GHOST", "GREEN", pos (6,3));
        level.createElement("GHOST", "YELLOW", pos (6,4));
        level.createElement("PACMAN",new Position (1,1));
        ElementHandler elem = level.getElementHandler("PACMAN");
        if (elem instanceof PacmanHandler){
            PacmanHandler pacmanHandler = (PacmanHandler) elem;
            Pacman pacman = ((Pacman) pacmanHandler.getElements().get(0));
            if (pacman != null){
                pacmanHandler.move(Movement.createNextPositionFrom(pacman.getPosition()));
                pacmanHandler.move(Movement.createNextPositionFrom(pacman.getPosition()));
                pacmanHandler.move(Movement.createNextPositionFrom(pacman.getPosition()));
                pacmanHandler.move(Movement.createNextPositionFrom(pacman.getPosition()));
                pacmanHandler.move(Movement.createNextPositionFrom(pacman.getPosition()));
                pacmanHandler.move(Movement.createNextPositionFrom(pacman.getPosition()));
                pacmanHandler.move(Movement.createNextPositionFrom(pacman.getPosition()));
                pacmanHandler.move(Movement.createNextPositionFrom(pacman.getPosition()));
                pacmanHandler.move(Movement.createNextPositionFrom(pacman.getPosition()));
                pacmanHandler.move(Movement.createNextPositionFrom(pacman.getPosition()));
                pacmanHandler.move(Movement.createNextPositionFrom(pacman.getPosition()));
                pacmanHandler.move(Movement.createNextPositionFrom(pacman.getPosition()));
            }

        }
        // placement of power pill
        level.createElement("PILL", "POWER", pos (2,2));

        // Example 1: eat fruit and corn from the same field
        level.createElement ("CORN", pos (1,1));
        level.createElement("FRUIT", "BANANA", pos (1,1));
        level.eat(pos (1,1));

        // Example 2: not able to eat the peach and it disappears
        level.createElement("FRUIT", "PEACH", pos (9,5));

        // Example 3: Pacman ate the power pil and eats all the ghosts
        level.eat(pos (2,2));
        Thread timer = new GameTimerTest(level);
        timer.start();
    }
}
