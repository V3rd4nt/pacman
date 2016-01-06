package Elements;

import java.util.ArrayList;
import java.util.List;

public class CornHandler extends ElementHandler {
    List<Corn> corns;

    public CornHandler() {
        corns = new ArrayList<>();
    }

    @Override
    public boolean create() {
        return false;
    }

    @Override
    public boolean create (Position pos) {
        for (Corn corn : corns) {
            if (corn.getPosition().getX() == pos.getX() && corn.getPosition().getY() == pos.getY()) {
                return false;
            }
        }
        corns.add(new Corn(pos));
        return true;
    }

    @Override
    public boolean create(String elementType, Position pos) {
        return false;
    }

    @Override
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

    @Override
    public int getNumberOfElements() {
        return corns.size();
    }

    @Override
    public List<?> getElements() {
        return corns;
    }

    private void getPoints (Corn corn) {
        Level.addScore(corn.getValue());
    }
}
