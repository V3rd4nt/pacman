package Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peter on 25.12.2015.
 */
public class FruitHandler implements ElementHandler {
    private List<Fruit> fruits;

    public FruitHandler () {
        fruits = new ArrayList<>();
    }

    @Override
    public boolean create (ElementType cType, Position pos) {
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
            default: return false;
        }
        fruits.add(fruit);
        destroy(fruit, fruit.getFruitType().getDisplayTime());
        return true;
    }

    @Override
    public boolean eat (Position pos) {
        int points = 0;
        for (Fruit fruit : fruits) {
            if (fruit.getPosition().getX() == pos.getX() && fruit.getPosition().getY() == pos.getY()) {
                getPoints(fruit);
                fruits.remove(fruit);
                return true;
            }
        }
        return false;
    }

    @Override
    public int getNumberOfElements() {
        return fruits.size();
    }

    private boolean destroy (Fruit fruit, int displayTime) {
        // countdown display time and delete fruit aftewards

        if (fruits.contains(fruit)) {
            fruits.remove(fruit);
            return true;
        } else return false;
    }

    private void getPoints (Fruit fruit) {
        Level.addScore(fruit.getFruitType().getValue());
    }
}
