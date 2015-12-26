package Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peter on 25.12.2015.
 */
public class GhostHandler implements ElementHandler {
    private List<Ghost> ghosts;

    public GhostHandler() {
        ghosts = new ArrayList<>();
    }

    @Override
    public boolean create (ElementType cType, Position pos) {

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
