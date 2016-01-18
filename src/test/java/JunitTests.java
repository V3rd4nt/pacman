import Pacman.Elements.*;
import Pacman.Util.Movement;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
        pacman = new Pacman (pos (1,1));
        level = new Level (pacman, new Lifes(3));
    }

    @Test
    public void test1_createMoreGhostsThanAllowed () {
        for (int i = 0; i < 4; i++) assertTrue(level.createElement("GHOST", Movement.createRandomPosition()));
        assertFalse(level.createElement("GHOST", Movement.createRandomPosition()));
        ((GhostHandler)level.getGhostHandler()).getElements().clear();
    }

    @Test
    public void test2_createAnElement () {
        assertTrue(level.createElement("CORN", Movement.createRandomPosition()));
    }

    @Test
    public void test3_createAnUndefinedElement () {
        assertFalse(level.createElement("UNDEFINED", Movement.createRandomPosition()));
    }

    @Test
    public void test4_createPositionOutsidePlayingField () {
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
    public void test5_createMorePillsThanAllowed () {
        for (int i = 0; i < 2; i++) assertTrue(level.createElement("PILL" , "POWER", Movement.createRandomPosition()));
        assertFalse(level.createElement("PILL" , "POWER", Movement.createRandomPosition()));
    }

    @Test
    public void test6_PacmanEatsAllGhostsAndGetsBonus () {
        ((PillHandler)level.getPillHandler()).setTestingState(true);

        level.createElement("PILL", "POWER", pos(1, 2));
        level.createElement("PILL", "POWER", pos(3, 3));
        level.createElement("GHOST", pos(15, 15));
        level.createElement("GHOST", pos(16, 15));
        level.createElement("GHOST", pos(17, 15));
        level.createElement("GHOST", pos(18, 15));

        pacman.setPosition(pos(1, 2));
        level.getPillHandler().eat(pos(1, 2));

        for(int x = 42; x > 1; x--) {
            pacman.setPosition(pos(x, 2));
        }
        ((Element)((GhostHandler)level.getGhostHandler()).getElements().get(0)).setPosition(pos(2,2));
        level.getGhostHandler().eat(pos(2, 2));

        for(int y = 43; y > 2; y--) {
            pacman.setPosition(pos(2, y));
        }
        ((Element)((GhostHandler)level.getGhostHandler()).getElements().get(0)).setPosition(pos(2,3));
        level.getGhostHandler().eat(pos(2, 3));

        pacman.setPosition(pos(3, 3));
        level.getPillHandler().eat(pos(3, 3));

        for(int y = 44; y > 3; y--) {
            pacman.setPosition(pos(3, y));
        }
        ((Element)((GhostHandler)level.getGhostHandler()).getElements().get(0)).setPosition(pos(3,4));
        level.getGhostHandler().eat(pos(3, 4));

        for(int x = 44; x > 3; x--) {
            pacman.setPosition(pos(x, 4));
        }
        ((Element)((GhostHandler)level.getGhostHandler()).getElements().get(0)).setPosition(pos(4,4));
        level.getGhostHandler().eat(pos(4, 4));

        ((GhostHandler)level.getGhostHandler()).getBonus();
        assertTrue(level.getScore() == 1600);
    }

    @Test
    public void test7_PacmanEatsGhost () {
        ((PillHandler)level.getPillHandler()).setTestingState(true);
        level.createElement("PILL", "POWER", pos (1,2));
        level.createElement("GHOST", pos (2,3));

        pacman.setPosition(pos (1,2));
        level.eat(pos (1,2));

        for(int x = 42; x > 1; x--) {
            pacman.setPosition(pos(x, 2));
        }
        ((Element)((GhostHandler)level.getGhostHandler()).getElements().get(0)).setPosition(pos(2,2));
        level.eat(pos(2, 2));
        assertTrue(level.getLifes() == 3);
    }

    @Test
    public void test8_PacmanGetsEatenByGhost () {
        ((PillHandler)level.getPillHandler()).setTestingState(true);
        level.createElement("GHOST", pos (2,2));

        pacman.setPosition(pos (2,2));
        level.eat(pos (2,2));

        assertTrue(level.getLifes() == 2);
    }

    @Test
    public void test9_PacmanEatsAllCorns(){
        level.setAllCorns();
        int row;
        int col = 0;

        while (col <= Position.getWIDTH())
        {
            row = 0;
            while (row <= Position.getHEIGHT()){
                if (! level.isWall(pos(col, row))){
                    pacman.setPosition(pos(col, row));
                    level.eat(pacman.getPosition());
                }

                row++;
            }
            col++;
        }
        assertTrue(level.getCornHandler().getElements().isEmpty());
    }
}
