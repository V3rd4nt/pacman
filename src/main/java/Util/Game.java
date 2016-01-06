package Util;

import Elements.*;

public class Game extends Thread {

    private Level level;
    private Position pos;

    public Game () {
        level = new Level ();

        level.createElement("GHOST", "RED", Position.getCenterPostition());
        level.createElement("GHOST", "BLUE", Position.getCenterPostition());
        level.createElement("GHOST", "GREEN", Position.getCenterPostition());
        level.createElement("GHOST", "YELLOW", Position.getCenterPostition());
        level.createElement("PACMAN", Position.getStartingPos());
        // TODO Create pills
    }

    @Override
    public void run() {

        PacmanHandler pacmanHandler;
        while (true) {
            // TODO move each ghost around and display their positions

            // move pacman around
            ElementHandler elem = level.getElementHandler("PACMAN");
            if (elem instanceof PacmanHandler){
                pacmanHandler = (PacmanHandler) elem;
                pacmanHandler.move();
            }

            // TODO implement eat method in pacman-class and delete it in level-class
            level.eat(pos);

            if (level.getLifes() == 0) break;
        }
        Messages.gameOver();
    }
}
