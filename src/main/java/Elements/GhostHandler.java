package Elements;

import Util.Messages;

import java.util.ArrayList;
import java.util.List;

public class GhostHandler extends ElementHandler {
    private List<Ghost> ghosts;

    public GhostHandler() {
        ghosts = new ArrayList<>();
    }

    @Override
    public boolean create (String elementType, Position pos) {
        Ghost ghost;
        switch(elementType) {
            case "RED":
                ghost = new Ghost (Ghost.Type.RED, pos);
                break;
            case "BLUE":
                ghost = new Ghost (Ghost.Type.BLUE, pos);
                break;
            case "GREEN":
                ghost = new Ghost (Ghost.Type.GREEN, pos);
                break;
            case "YELLOW":
                ghost = new Ghost (Ghost.Type.YELLOW, pos);
                break;
            default: return false;
        }
        ghosts.add(ghost);

        Messages.appear(ghost);

        return true;
    }

    @Override
    public boolean eat (Position pos) {
        for (Ghost ghost : ghosts) {
            if (ghost.getPosition().getX() == pos.getX() && ghost.getPosition().getY() == pos.getY()) {
                ghosts.remove(ghost);

                Messages.pacmanEat(ghost);

                return true;
            }
        }
        return false;
    }

    @Override
    public int getNumberOfElements() {
        return ghosts.size();
    }

    @Override
    public List<?> getElements() {
        return ghosts;
    }
}
