package Elements;

import Util.Messages;
import Util.EventTimer1;

import java.util.ArrayList;
import java.util.List;

public class FruitHandler extends ElementHandler {
    private List<Fruit> fruits;
    private Thread timer;

    public FruitHandler () {
        fruits = new ArrayList<>();
    }

    @Override
    public boolean create (String elementType, Position pos) {
        Fruit fruit;
        switch(elementType) {
            case "CHERRY":
                fruit = new Fruit(Fruit.Type.CHERRY, pos);
                break;
            case "APPLE":
                fruit = new Fruit(Fruit.Type.APPLE, pos);
                break;
            case "STRAWBERRY":
                fruit = new Fruit(Fruit.Type.STRAWBERRY, pos);
                break;
            case "PEACH":
                fruit = new Fruit(Fruit.Type.PEACH, pos);
                break;
            case "BANANA":
                fruit = new Fruit(Fruit.Type.BANANA, pos);
                break;
            default: return false;
        }
        fruits.add(fruit);

        Messages.appear(fruit);

        timer = new EventTimer1(fruit.getType().getDisplayTime(), this, null, fruit);
        timer.start();
        return true;
    }

    @Override
    public boolean eat (Position pos) {
        for (Fruit fruit : fruits) {
            if (fruit.getPosition().getX() == pos.getX() && fruit.getPosition().getY() == pos.getY()) {
                timer.interrupt();
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

    @Override
    public List<?> getElements() {
        return fruits;
    }

    private void getPoints (Fruit fruit) {
        Level.addScore(fruit.getType().getValue());
    }

}
