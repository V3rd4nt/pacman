package Util;

import Elements.*;

public class Game extends Thread {

    private Level level;
    private Position pos;
    Element pacman;

    public Game () {
        level = new Level ();
        pacman = new Pacman (new Position (1,1));
        level.createElement("GHOST", "RED", Movement.createRandomPosition());
        level.createElement("GHOST", "BLUE", Movement.createRandomPosition());
        level.createElement("GHOST", "GREEN", Movement.createRandomPosition());
        level.createElement("GHOST", "YELLOW", Movement.createRandomPosition());
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
