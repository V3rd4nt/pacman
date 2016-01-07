package Elements;

import Util.Messages;

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
    public boolean create(Position pos) {
        return this.create("CORN", pos);
    }

    @Override
    public boolean create (String elementType, Position pos) {

        Corn corn = new Corn(pos);
        corns.add(corn);
        Messages.appear(corn);
        return true;
    }

    @Override
    public boolean eat (Position pos) {
        for (Corn corn : corns) {
            if (corn.getPosition().getX() == pos.getX() && corn.getPosition().getY() == pos.getY()) {
                getPoints(corn);
                corns.remove(corn);
                Messages.pacmanEatenBy(corn);
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
