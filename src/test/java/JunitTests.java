import Pacman.Elements.Level;
import Pacman.Elements.Lifes;
import Pacman.Elements.Pacman;
import Pacman.Elements.Position;
import Pacman.Util.Movement;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JunitTests  {

    private Level level;
    private Pacman pacman;

    public JunitTests () {
    }

    @Before
    public void initTest () {
        pacman = new Pacman (new Position (3,3));
        level = new Level (pacman, new Lifes(3));
    }

    @Test
    public void createAnElements () {
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
        Position pos = new Position (x, y);
        assertTrue(pos.getX() == Position.getWIDTH());
        assertTrue(pos.getY() == Position.getHEIGHT());

        x = -10;
        y = -10;
        pos = new Position (x, y);
        assertTrue(pos.getX() == 0);
        assertTrue(pos.getY() == 0);
    }

    public void createMorePillsThanAllowed () {
        for (int i = 0; i < 2; i++) assertTrue(level.createElement("PILL" , "POWER", Movement.createRandomPosition()));
        assertTrue(level.createElement("PILL" , "POWER", Movement.createRandomPosition()));
    }

    @Test
    public void PacmanEatsGhost () {
        level.createElement("GHOST", new Position (5,5));
        level.createElement("PILL" , "POWER", new Position (4,4));

        pacman.setPosition(new Position (4,4));
        level.eat(pacman.getPosition());

        pacman.setPosition(new Position (5,5));
        assertTrue(level.eat(pacman.getPosition()));
    }

    @Test
    public void PacmanGetsEatenByGhost () {

    }

    @Test
    public void PacmanEatsAllGhostsAndGetsBonus () {

    }
}
