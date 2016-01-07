package Elements;

import Util.Messages;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Florian on 07/01/16.
 */
public class WallHandler extends ElementHandler {
    private List<Wall> walls;

    public  WallHandler(){
        this.walls = new ArrayList<Wall>();
    }
    @Override
    public boolean create(String elementType, Position pos) {
        Wall wall = new Wall(pos);
        walls.add(wall);
        Messages.appear(wall);
        return true;
    }

    @Override
    public boolean create(Position pos) {
        return this.create("WALL", pos);
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
    public int getNumberOfElements() {
        return this.walls.size();
    }

    @Override
    public List<?> getElements() {
        return this.walls;
    }
}
