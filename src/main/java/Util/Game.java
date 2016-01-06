package Util;

import Elements.*;

import java.util.List;
import java.util.ArrayList;

public class Game extends Thread {

    private Level level;
    Element pacman;
    List<Ghost> ghosts;

    public static Position pos (int x, int y) {
        return new Position (x, y);
    }

    @Override
    public void run() {
        setup();

        // creates first fruit
        level.createElement("FRUIT", null);
        try {
            while (true) {
                Thread.sleep(1);

                ghosts = (List<Ghost>) level.getGhostHandler().getElements();
                for (Ghost ghost : ghosts) {
                    ghost.setPosition(Movement.createNextPositionFrom(ghost.getPosition()));
                }

                // move pacman around
                pacman.setPosition(Movement.createNextPositionFrom(pacman.getPosition()));
                level.eat(pacman.getPosition());

                if (level.getLifes() == 0) break;
            }
        } catch (InterruptedException e) {
        interrupt();
    }
        Messages.gameOver();
    }

    private void setup () {
        level = new Level (new Lifes(3));

        // creates 4 ghosts
/*        level.createElement("GHOST", Movement.createRandomPosition());
        level.createElement("GHOST", Movement.createRandomPosition());
        level.createElement("GHOST", Movement.createRandomPosition());
        level.createElement("GHOST", Movement.createRandomPosition());*/

        // creates pacman
        pacman = new Pacman (Position.getStartingPos());

        // creates 2 pills
        level.createElement("PILL", "POWER", pos (5, 20));
        level.createElement("PILL", "POWER", pos (15, 20));
    }
}
