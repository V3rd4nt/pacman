package Collectables;

/**
 * Created by armor on 25.12.2015.
 */
public interface CollectablesHandler {

    public int createCtype (CollectableType cType, Position pos);
    public boolean delete (Position pos);
    public int getPoints (Position pos);
    public int getMaxOcurrence (Position pos);
}
