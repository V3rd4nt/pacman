package Collectables;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by armor on 25.12.2015.
 */
public class CornHandler implements CollectablesHandler {
    List<Corn> corns;

    public CornHandler() {
        corns = new ArrayList<Corn>();
    }

    public boolean create (CollectableType cType, Position pos) {

        // impement check if position is already used by another corn
        Corn corn = new Corn(pos);
        corns.add(corn);
        return true;
    }

    public boolean eat (Position pos) {
        for (Corn corn : corns) {
            if (corn.getPosition().getX() == pos.getX() && corn.getPosition().getY() == pos.getY()) {
                getPoints(corn);
                corns.remove(corn);
                return true;
            }
        }
        return false;
    }

    private void getPoints (Corn corn) {
        Collectables.addScore(corn.getValue());
    }
}
