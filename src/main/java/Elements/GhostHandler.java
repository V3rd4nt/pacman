package Elements;

import java.util.ArrayList;
import java.util.List;

public class GhostHandler implements ElementHandler {
    private List<Ghost> ghosts;

    public GhostHandler() {
        ghosts = new ArrayList<>();
    }

    @Override
    public boolean create (String elementType, Position pos) {

        // elementType can be used to set the color of the ghost
        Ghost ghost = new Ghost (pos);
        ghosts.add(ghost);
        return true;
    }

    @Override
    public boolean eat (Position pos) {
        for (Ghost ghost : ghosts) {
            if (ghost.getPosition().getX() == pos.getX() && ghost.getPosition().getY() == pos.getY()) {
                ghosts.remove(ghost);
                return true;
            }
        }
        return false;
    }

    @Override
    public int getNumberOfElements() {
        return ghosts.size();
    }
}
