package Pacman.Elements;

import Pacman.Elements.*;
import Pacman.Util.Messages;
import Pacman.Util.Movement;

import java.util.List;

public class Game extends Thread {

    private Level level;
    Pacman pacman;
    List<Ghost> ghosts;

    public static Position pos (int x, int y) {
        return new Position (x, y);
    }

    @Override
    public void run() {
        setup();

        // creates first fruit
        level.createElement("FRUIT", null);
        Position nextPos;
        ghosts = (List<Ghost>) level.getGhostHandler().getElements();

        try {
            while (true) {
                Thread.sleep(10);

                // moves ghosts around
                for (Ghost ghost : ghosts) {
                    do { nextPos = Movement.createNextPositionFrom(ghost.getPosition()); } while (level.isWall (nextPos));
                    ghost.setPosition(nextPos);
                }
                // moves pacman around
                do { nextPos = Movement.createNextPositionFrom(pacman.getPosition()); } while (level.isWall (nextPos));
                pacman.setPosition(nextPos);

                // pacman eats
                level.eat(pacman.getPosition());

                // checks for game state and aborts if all lifes are gone or all corns are eaten by pacman
                if (level.getLifes() == 0 || level.getCornHandler().getElements().isEmpty()) break;
            }
        } catch (InterruptedException e) {
        interrupt();
    }
        // stops running threads of fruitHandler timer
        ((FruitHandler)level.getFruitHandler()).stopTimer();

        // if ghosts were eaten, get the bonus score
        ((GhostHandler)level.getGhostHandler()).getBonus();

        Messages.gameOver();
        Messages.displayScore(level.getScore());
    }

    private void setup () {

        // creates pacman
        pacman = new Pacman (Position.getStartingPos());

        // sets up a new level with 3 lifes
        level = new Level (pacman, new Lifes(3));

        // fills playing field with corns
        level.setAllCorns();

        // creates 4 ghosts
        level.createElement("GHOST", Movement.createRandomPosition());
        level.createElement("GHOST", Movement.createRandomPosition());
        level.createElement("GHOST", Movement.createRandomPosition());
        level.createElement("GHOST", Movement.createRandomPosition());

        // creates 2 power pills
        level.createElement("PILL", "POWER", pos (5, 20));
        level.createElement("PILL", "POWER", pos (15, 20));
    }
}
