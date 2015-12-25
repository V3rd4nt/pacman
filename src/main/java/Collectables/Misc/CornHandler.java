package Collectables.Misc;

import Collectables.CollectableType;
import Collectables.CollectablesHandler;
import Collectables.Position;

/**
 * Created by armor on 25.12.2015.
 */
public class CornHandler implements CollectablesHandler{

    public CornHandler () {

    }

    @Override
    public int createCtype(CollectableType cType, Position pos) {
        return 0;
    }

    @Override
    public boolean delete(Position pos) {
        return false;
    }

    @Override
    public int getPoints(Position pos) {
        return 0;
    }

    @Override
    public int getMaxOcurrence(Position pos) {
        return 0;
    }
}
