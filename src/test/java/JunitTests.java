import Pacman.Elements.*;
import Pacman.Util.Movement;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import java.util.Stack;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JunitTests  {

    public static Position pos (int x, int y) {
        return new Position (x, y);
    }

    private void delay (Pacman pacman) {
        for(int i = 0; i < 50; i++) {
            pacman.setPosition(Movement.createRandomPosition());
        }
    }

    private Level level;
    private Pacman pacman;

    public JunitTests () {
    }

    @Before
    public void initTest () {
        pacman = new Pacman (pos (1,1));
        level = new Level (pacman, new Lifes(3));
        level.resetScore();
    }

    @Test
    public void Test_A_createMoreGhostsThanAllowed () {
        for (int i = 0; i < 4; i++) assertTrue(level.createElement("GHOST", Movement.createRandomPosition()));
        assertFalse(level.createElement("GHOST", Movement.createRandomPosition()));
        ((GhostHandler)level.getGhostHandler()).getElements().clear();
    }

    @Test
    public void Test_B_createAnElement () {
        assertTrue(level.createElement("CORN", Movement.createRandomPosition()));
        assertTrue(level.createElement("GHOST", Movement.createRandomPosition()));
        assertTrue(level.createElement("PILL", "POWER", Movement.createRandomPosition()));
        assertTrue(level.createElement("WALL", Movement.createRandomPosition()));
    }

    @Test
    public void Test_C_createAnUndefinedElement () {
        assertFalse(level.createElement("UNDEFINED", Movement.createRandomPosition()));
    }

    @Test
    public void Test_D_createPositionOutsidePlayingField () {
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
    public void Test_E_createMorePillsThanAllowed () {
        for (int i = 0; i < 2; i++) assertTrue(level.createElement("PILL" , "POWER", Movement.createRandomPosition()));
        assertFalse(level.createElement("PILL" , "POWER", Movement.createRandomPosition()));
    }

    @Test
    public void Test_F_CountPointsOfCorns(){
        level.setAllCorns();
        int cornEatCounter = 0, col = 0;
        int pointsPerCoin = ((Corn) ((CornHandler)level.getCornHandler()).getElements().get(0)).getValue();
        while (col <= Position.getWIDTH())
        {
            if (! level.isWall(pos(col, 2))){
                pacman.setPosition(pos(col, 2));
                level.eat(pacman.getPosition());
                cornEatCounter++;
            }
            col++;
        }
        assertTrue(level.getScore() == cornEatCounter*pointsPerCoin);
    }

    @Test
    public void Test_G_PacmanEatsAllGhostsAndGetsBonus () {
        level.createElement("PILL", "POWER", pos(1, 2));
        level.createElement("PILL", "POWER", pos(3, 3));
        level.createElement("GHOST", pos(15, 15));
        level.createElement("GHOST", pos(16, 15));
        level.createElement("GHOST", pos(17, 15));
        level.createElement("GHOST", pos(18, 15));

        // eat 1st power pill
        pacman.setPosition(pos(1, 2));
        level.getPillHandler().eat(pos(1, 2));

        // eat 2 ghosts during power pill effect
        delay(pacman);
        ((Element)((GhostHandler)level.getGhostHandler()).getElements().get(0)).setPosition(pos(2,2));
        level.getGhostHandler().eat(pos(2, 2));

        delay(pacman);
        ((Element)((GhostHandler)level.getGhostHandler()).getElements().get(0)).setPosition(pos(2,3));
        level.getGhostHandler().eat(pos(2, 3));

        // eat 2nd power pill
        pacman.setPosition(pos(3, 3));
        level.getPillHandler().eat(pos(3, 3));

        // eat 2 additional ghosts during power pill effect
        delay(pacman);
        ((Element)((GhostHandler)level.getGhostHandler()).getElements().get(0)).setPosition(pos(3,4));
        level.getGhostHandler().eat(pos(3, 4));

        delay(pacman);
        ((Element)((GhostHandler)level.getGhostHandler()).getElements().get(0)).setPosition(pos(4,4));
        level.getGhostHandler().eat(pos(4, 4));

        // calculates bonus
        ((GhostHandler)level.getGhostHandler()).getBonus();

        // score has to be 1600 if all ghosts were eaten
        assertTrue(level.getScore() == 1600);
    }

    @Test
    public void Test_H_PacmanEatsGhost () {
        level.createElement("PILL", "POWER", pos (1,2));
        level.createElement("GHOST", pos (2,3));
        pacman.setPosition(pos (1,2));
        level.eat(pos (1,2));
        delay(pacman);
        ((Element)((GhostHandler)level.getGhostHandler()).getElements().get(0)).setPosition(pos(2,2));
        level.eat(pos(2, 2));
        assertTrue(level.getLifes() == 3);
    }

    @Test
    public void Test_I_PacmanGetsEatenByGhost () {
        level.createElement("GHOST", pos (2,2));
        pacman.setPosition(pos (2,2));
        level.eat(pos (2,2));
        assertTrue(level.getLifes() == 2);
    }

    @Test
    public void Test_J_PacmanEatsAllCorns() {
        level.setAllCorns();
        int row, col = 0;

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

    @Test
    public void Test_K_PacmanEatsAllFruits() {

        ElementHandler fh = level.getFruitHandler();
        level.createElement("FRUIT", null);

        while (!fh.getElements().isEmpty()){
            Fruit fruit = ((Stack<Fruit>) fh.getElements()).peek() ;
            pacman.setPosition(fruit.getPosition());
            level.eat(pacman.getPosition());
        }
        assertTrue(level.getScore() == 6200);
    }
}
