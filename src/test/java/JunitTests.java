import Pacman.Elements.*;
import Pacman.Util.Movement;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JunitTests  {

    public static Position pos (int x, int y) {
        return new Position (x, y);
    }

    private Level level;
    private Pacman pacman;

    public JunitTests () {
    }

    @Before
    public void initTest () {
        pacman = new Pacman (pos (3,3));
        level = new Level (pacman, new Lifes(3));
    }

    @Test
    public void createAnElement () {
        assertTrue(level.createElement("CORN", Movement.createRandomPosition()));
    }

    @Test
    public void createAnUndefinedElement () {
        assertFalse(level.createElement("UNDEFINED", Movement.createRandomPosition()));
    }

    @Test
    public void createMoreGhostsThanAllowed () {
        for (int i = 0; i < 4; i++) assertTrue(level.createElement("GHOST", Movement.createRandomPosition()));
        assertFalse(level.createElement("GHOST", Movement.createRandomPosition()));
    }

    @Test
    public void createPositionOutsidePlayingField () {
        int x = Position.getWIDTH()+10;
        int y = Position.getHEIGHT()+10;
        Position pos = pos (x, y);
        assertTrue(pos.getX() == Position.getWIDTH());
        assertTrue(pos.getY() == Position.getHEIGHT());

        x = -10;
        y = -10;
        pos = pos (x, y);
        assertTrue(pos.getX() == 0);
        assertTrue(pos.getY() == 0);
    }

    @Test
    public void createMorePillsThanAllowed () {
        for (int i = 0; i < 2; i++) assertTrue(level.createElement("PILL" , "POWER", Movement.createRandomPosition()));
        assertFalse(level.createElement("PILL" , "POWER", Movement.createRandomPosition()));
    }

    @Test
    public void PacmanEatsGhost () {
        pacman = new Pacman (pos (3,3));
        level = new Level (pacman, new Lifes(3));

        level.createElement("PILL", "POWER", pos (1,2));
        pacman.setPosition(pos (1,2));
        level.eat(pos (1,2));
        level.createElement("GHOST", pos (2,2));
        pacman.setPosition(pos (2,2));
        level.eat(pos (2,2));
        assertTrue(level.getLifes() == 3);
    }

    @Test
    public void PacmanGetsEatenByGhost () {
        pacman = new Pacman (pos (3,3));
        level = new Level (pacman, new Lifes(3));

        level.createElement("GHOST", pos (2,2));
        pacman.setPosition(pos (2,2));
        level.eat(pos (2,2));
        assertTrue(level.getLifes() == 2);
    }

    public void PacmanEatsAllGhostsAndGetsBonus () {

    }
}
