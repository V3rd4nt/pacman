package Elements;

import Util.Messages;
import Util.Movement;

import java.util.ArrayList;
import java.util.List;

public class GhostHandler extends ElementHandler {
    private List<Ghost> ghosts;
    private int ocurrence;
    private boolean vulnerable;
    private Lifes lifes;
    private Pacman pacman;

    public GhostHandler (Lifes lifes, Pacman pacman) {
        ghosts = new ArrayList<>();
        vulnerable = false;
        ocurrence = 0;
        this.lifes = lifes;
        this.pacman = pacman;
    }

    @Override
    public boolean create() {
        return false;
    }

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

    @Override
    public boolean create(String elementType, Position pos) {
        return false;
    }

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

    @Override
    public int getNumberOfElements() {
        return ghosts.size();
    }

    @Override
    public List<?> getElements() {
        return ghosts;
    }

    public void setVulnerable (boolean value) {
        vulnerable = value;
    }

    private void getPoints (Ghost ghost) {
        Level.addScore(ghost.getType().getValue());
    }
}
