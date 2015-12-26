package Collectables;

/**
 * Created by armor on 26.12.2015.
 */
public interface CollectablesHandler {

    public boolean create (CollectableType cType, Position pos);
    public boolean eat (Position pos);
}
