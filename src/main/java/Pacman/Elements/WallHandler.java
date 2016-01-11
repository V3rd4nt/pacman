package Pacman.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * WallHandler Class
 */
public class WallHandler implements ElementHandler {
    private List<Wall> walls;

    /**
     * Creates a new WallHandler
     */
    public  WallHandler (){
        walls = new ArrayList<>();
    }

    /**
     * Not implemented: use create (Position pos)
     */
    @Override
    public boolean create(String elementType, Position pos) {
        return false;
    }

    /**
     * Creates a new Wall on the specified Position
     * @param pos specified position
     * @return true if successfully created, false if otherwise
     */
    @Override
    public boolean create(Position pos) {
        walls.add(new Wall(pos));
        return true;
    }

    /**
     * Not implemented: use create (Position pos)
     */
    @Override
    public boolean create() {
        return false;
    }

    /**
     * Not implemented: Walls can't be eaten by Pacman
     */
    @Override
    public boolean eat(Position pos) {
        return false;
    }

    /**
     * Returns all available Walls
     * @return list of Walls
     */
    @Override
    public List<?> getElements() {
        return walls;
    }
}
