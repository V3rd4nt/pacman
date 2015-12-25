package Collectables;

import Collectables.Fruit.*;
import Collectables.Pill.*;
import Collectables.Misc.*;

/**
 * Created by armor on 25.12.2015.
 */
public class Collectables {

    CollectablesHandler fruitHandler, pillHandler, cornHandler;
    Key key;

    public Collectables () {
        fruitHandler = new FruitHandler();
        pillHandler = new PillHandler();
        cornHandler = new CornHandler();
        key = new Key();
    }

    public Object createCtype (Object o) {

        return null;
    }

    private Position randomPosition () {
        return new Position (1, 1);
    }
}
