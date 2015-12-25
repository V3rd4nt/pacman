package Collectables.Fruit;

import Collectables.Position;
import Collectables.CollectableType;
import Collectables.CollectablesHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by armor on 25.12.2015.
 */
public class FruitHandler implements CollectablesHandler {
    List<Fruit> fruits;

    public FruitHandler () {
        fruits = new ArrayList<Fruit>();
    }

    public int createCtype(CollectableType cType, Position pos) {
        Fruit fruit;
        switch(cType) {
            case CHERRY:
                fruit = new Fruit(Fruit.FruitType.CHERRY, pos);
                break;
            case APPLE:
                fruit = new Fruit(Fruit.FruitType.APPLE, pos);
                break;
            case STRAWBERRY:
                fruit = new Fruit(Fruit.FruitType.STRAWBERRY, pos);
                break;
            case PEACH:
                fruit = new Fruit(Fruit.FruitType.PEACH, pos);
                break;
            case BANANA:
                fruit = new Fruit(Fruit.FruitType.BANANA, pos);
                break;
            default: return 0;
        }
        fruits.add(fruit);
        return fruit.getFruitType().getDisplayTime();
    }

    public boolean delete (Position pos) {
        for (Fruit fruit : fruits) {
            if (fruit.getPosition().getX() == pos.getX() && fruit.getPosition().getY() == pos.getY()) {
                fruits.remove(fruit);
                return true;
            }
        }
        return false;
    }
    public int getPoints (Position pos) {
        int points = 0;
        for (Fruit fruit : fruits) {
            if (fruit.getPosition().getX() == pos.getX() && fruit.getPosition().getY() == pos.getY()) {
                points = fruit.getFruitType().getValue();
                fruits.remove(fruit);
            }
        }
        return points;
    }

    public int getMaxOcurrence (Position pos) {
        return 0;
    }
}
