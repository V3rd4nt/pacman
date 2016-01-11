package Pacman.Elements;

import Pacman.Util.Messages;
import java.util.ArrayList;
import java.util.List;

/**
 * GhostHandler Class
 */
public class GhostHandler implements ElementHandler {
    private List<Ghost> ghosts;
    private int ocurrence;
    private boolean vulnerable;
    private Lifes lifes;
    private Pacman pacman;

    /**
     * Creates a new GhostHandler
     */
    public GhostHandler (Lifes lifes, Pacman pacman) {
        ghosts = new ArrayList<>();
        vulnerable = false;
        ocurrence = 0;
        this.lifes = lifes;
        this.pacman = pacman;
    }

    /**
     * Not implemented: use create (Position pos)
     */
    @Override
    public boolean create() {
        return false;
    }

    /**
     * Creates a new Ghost on the specified Position
     * (Not allowed to create more than 4 ghosts)
     * @param pos specified position
     * @return true if successfully created, false if otherwise
     */
    @Override
    public boolean create (Position pos) {

        Ghost ghost;
        switch(ocurrence) {
            case 0:
                ghost = new Ghost (Ghost.Type.RED, pos);
                break;
            case 1:
                ghost = new Ghost (Ghost.Type.BLUE, pos);
                break;
            case 2:
                ghost = new Ghost (Ghost.Type.GREEN, pos);
                break;
            case 3:
                ghost = new Ghost (Ghost.Type.YELLOW, pos);
                break;
            default: return false;
        }
        ocurrence += 1;
        ghosts.add(ghost);
        Messages.appear(ghost);
        return true;
    }

    /**
     * Not implemented: use create (Position pos)
     */
    @Override
    public boolean create(String elementType, Position pos) {
        return false;
    }

    /**
     * Tries to remove a Ghost on the specified position
     * (Removing of ghosts only possible in vulnerable state (Power Pill effect). If ghosts are
     * not vulnerable Pacman looses one life and gets set back to the it's starting position)
     * @param pos specified position
     * @return true if Ghost was removed, false if otherwise
     */
    @Override
    public boolean eat (Position pos) {
        for (Ghost ghost : ghosts) {
            if (ghost.getPosition().getX() == pos.getX() && ghost.getPosition().getY() == pos.getY()) {
                if (vulnerable) {
                    getPoints(ghost);
                    ghosts.remove(ghost);
                    Messages.pacmanEat(ghost);
                    return true;
                } else {
                    Messages.pacmanEatenBy(ghost);
                    lifes.looseLife();
                    Messages.lifeLost(lifes.getAmount());
                    pacman.setPosition(Position.getStartingPos());
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * Adds bonus to the score if at least 3 ghosts were eaten during the Power Pill effect
     */
    public void getBonus () {
        int score;
        switch (ghosts.size()) {
            case 1:
                score = 400;
                Messages.displayBonusScore(3, score);
                break;
            case 0:
                score = 800;
                Messages.displayBonusScore(4, score);
                break;
            default: return;
        }
        Level.addScore(score);
    }

    /**
     * Returns all available Ghosts
     * @return list of Ghosts
     */
    @Override
    public List<?> getElements() {
        return ghosts;
    }

    /**
     * Sets vulnerable state to specified value
     * @param value specified value
     */
    public void setVulnerable (boolean value) {
        vulnerable = value;
    }

    private void getPoints (Ghost ghost) {
        Level.addScore(ghost.getType().getValue());
    }
}
