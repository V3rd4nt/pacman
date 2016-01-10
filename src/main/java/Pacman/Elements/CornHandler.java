package Pacman.Elements;

import Pacman.Util.Messages;
import java.util.ArrayList;
import java.util.List;

public class CornHandler implements ElementHandler {
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
        Corn corn = new Corn(pos);
        corns.add(corn);
        return true;
    }

    @Override
    public boolean create (String elementType, Position pos) {
        return false;
    }

    @Override
    public boolean eat (Position pos) {
        for (Corn corn : corns) {
            if (corn.getPosition().getX() == pos.getX() && corn.getPosition().getY() == pos.getY()) {
                getPoints(corn);
                corns.remove(corn);
                Messages.pacmanEat(corn);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<?> getElements() {
        return corns;
    }

    private void getPoints (Corn corn) {
        Level.addScore(corn.getValue());
    }
}
