package Util;

import Elements.*;

import java.util.List;

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
                Thread.sleep(10);

                // moves ghosts around
                ghosts = (List<Ghost>) level.getGhostHandler().getElements();
                for (Ghost ghost : ghosts) {
                    ghost.setPosition(Movement.createNextPositionFrom(ghost.getPosition()));
                }

                // TODO set pacman back to startposition after he lost a life

                // moves pacman around
                pacman.setPosition(Movement.createNextPositionFrom(pacman.getPosition()));

                // pacman eats
                level.eat(pacman.getPosition());

                // checks for game state and aborts if all lifes are gone
                if (level.getLifes() == 0) break;
            }
        } catch (InterruptedException e) {
        interrupt();
    }
        // stops running threads of fruitHandler timer
        ((FruitHandler)level.getFruitHandler()).stopTimer();

        Messages.gameOver();
        Messages.displayScore(level.getScore());
    }

    private void setup () {
        // sets up a new level with 3 lifes
        level = new Level (new Lifes(3));

        // creates 4 ghosts
        level.createElement("GHOST", Movement.createRandomPosition());
        level.createElement("GHOST", Movement.createRandomPosition());
        level.createElement("GHOST", Movement.createRandomPosition());
        level.createElement("GHOST", Movement.createRandomPosition());

        // creates pacman
        pacman = new Pacman (Position.getStartingPos());

        // creates 2 power pills
        level.createElement("PILL", "POWER", pos (5, 20));
        level.createElement("PILL", "POWER", pos (15, 20));

        // fills playing field with corns

        // TODO implement method
        level.setAllCorns();
    }
}
