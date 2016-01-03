import Elements.*;
import Util.GameTimerTest;

public class Main {
    public static Position pos (int x, int y) {
        return new Position (x, y);
    }

    public static void main (String[] args) {

        // level size see Position class
        Level level = new Level ();

        // ghost creation
        level.createElement("GHOST", "RED", pos (6,1));
        level.createElement("GHOST", "BLUE", pos (6,2));
        level.createElement("GHOST", "GREEN", pos (6,3));
        level.createElement("GHOST", "YELLOW", pos (6,4));

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
