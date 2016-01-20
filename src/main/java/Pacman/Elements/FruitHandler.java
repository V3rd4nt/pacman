package Pacman.Elements;

import Pacman.Util.Messages;
import Pacman.Util.EventTimer;
import Pacman.Util.Movement;

import java.util.List;
import java.util.Stack;

/**
 * FruitHandler Class
 */
public class FruitHandler implements ElementHandler {
    private Stack<Fruit> fruits;
    private Thread timer;

    /**
     * Creates a new FruitHandler
     */
    public FruitHandler () {

        fruits = new Stack<>();
        fruits.push(new Fruit(Fruit.Type.BANANA, Movement.createRandomPosition()));
        fruits.push(new Fruit(Fruit.Type.PEACH, Movement.createRandomPosition()));
        fruits.push(new Fruit(Fruit.Type.STRAWBERRY, Movement.createRandomPosition()));
        fruits.push(new Fruit(Fruit.Type.APPLE, Movement.createRandomPosition()));
        fruits.push(new Fruit(Fruit.Type.CHERRY, Movement.createRandomPosition()));
    }

    /**
     * Creates a new Fruit
     * (Creates and starts a new EventTimer Thread)
     * @return true if successfully created, false if otherwise
     */
    @Override
    public boolean create () {
        if (!fruits.isEmpty()) {
            if (fruits.peek() != null) {
                if(!timer.isInterrupted()) {
                    Fruit fruit = fruits.peek();
                    Messages.appear(fruit);
                    timer = new EventTimer(fruit.getType().getDisplayTime(), this, null, fruit);
                    timer.start();
                    return true;
                }
            } else return false;
        } else return false;
    }

    /**
     * Not implemented: use create ()
     */
    @Override
    public boolean create(Position pos) {
        return false;
    }

    /**
     * Not implemented: use create ()
     */
    @Override
    public boolean create(String elementType, Position pos) {
        return false;
    }

    /**
     * Tries to remove a Fruit on the specified position
     * @param pos specified position
     * @return true if Fruit was removed, false if otherwise
     */
    @Override
    public boolean eat (Position pos) {
        if (!fruits.isEmpty()) {
            if (fruits.peek().getPosition().getX() == pos.getX() && fruits.peek().getPosition().getY() == pos.getY()) {
                if (timer != null) timer.interrupt();
                getPoints(fruits.peek());
                Messages.pacmanEat(fruits.peek());
                fruits.pop();
                create();
                return true;
            }
            return false;
        } else return false;
    }

    // TODO Changed
    /**
     * Stops the EventTimer Thread
     */
    public void stopTimer () {
        if (timer != null) timer.interrupt();
    }

    /**
     * Returns all available Fruits
     * @return list of Fruits
     */
    @Override
    public List<?> getElements() {
        return fruits;
    }

    private void getPoints (Fruit fruit) {
        Level.addScore(fruit.getType().getValue());
    }
}
