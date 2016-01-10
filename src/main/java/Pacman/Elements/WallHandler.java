package Pacman.Elements;

import java.util.ArrayList;
import java.util.List;

public class WallHandler implements ElementHandler {
    private List<Wall> walls;

    public  WallHandler (){
        walls = new ArrayList<>();
    }

    @Override
    public boolean create(String elementType, Position pos) {
        return false;
    }

    @Override
    public boolean create(Position pos) {
        walls.add(new Wall(pos));
        return true;
    }

    @Override
    public boolean create() {
        return false;
    }

    @Override
    public boolean eat(Position pos) {
        return false;
    }

    @Override
    public List<?> getElements() {
        return walls;
    }
}
