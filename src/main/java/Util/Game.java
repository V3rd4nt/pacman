package Util;

import Elements.*;

public class Game extends Thread {

    private Level level;
    private Position pos;
    Element pacman;

    public Game () {
        level = new Level ();

        level.createElement("GHOST", Movement.createRandomPosition());
        level.createElement("GHOST", Movement.createRandomPosition());
        level.createElement("GHOST", Movement.createRandomPosition());
        level.createElement("GHOST", Movement.createRandomPosition());
        level.createElement("PACMAN", new Position (1,1));
        // TODO Create pills
    }

    @Override
    public void run() {
        while (true) {
            // TODO move each ghost around and display their positions

            // move pacman around
            pacman.setPosition(Movement.createNextPositionFrom(pacman.getPosition()));

            // displays position of pacman
            Messages.position(pacman);

            // TODO implement eat method in pacman-class and delete it in level-class
            level.eat(pos);

            if (level.getLifes() == 0) break;
        }
        Messages.gameOver();
    }
}
