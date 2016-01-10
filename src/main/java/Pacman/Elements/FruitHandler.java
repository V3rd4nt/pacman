package Pacman.Elements;

import Pacman.Util.Messages;
import Pacman.Util.EventTimer;
import Pacman.Util.Movement;

import java.util.List;
import java.util.Stack;

public class FruitHandler extends ElementHandler {
    private Stack<Fruit> fruits;
    private Thread timer;

    public FruitHandler () {

        fruits = new Stack<>();
        fruits.push(new Fruit(Fruit.Type.BANANA, Movement.createRandomPosition()));
        fruits.push(new Fruit(Fruit.Type.PEACH, Movement.createRandomPosition()));
        fruits.push(new Fruit(Fruit.Type.STRAWBERRY, Movement.createRandomPosition()));
        fruits.push(new Fruit(Fruit.Type.APPLE, Movement.createRandomPosition()));
        fruits.push(new Fruit(Fruit.Type.CHERRY, Movement.createRandomPosition()));
    }

    @Override
    public boolean create () {
        if (!fruits.isEmpty()) {
            if (fruits.peek() != null) {
                Fruit fruit = fruits.peek();
                Messages.appear(fruit);
                timer = new EventTimer(fruit.getType().getDisplayTime(), this, null, fruit);
                timer.start();
                return true;
            } else return false;
        } else return false;
    }

    @Override
    public boolean create(Position pos) {
        return false;
    }

    @Override
    public boolean create(String elementType, Position pos) {
        return false;
    }

    @Override
    public boolean eat (Position pos) {
        if (!fruits.isEmpty()) {
            if (fruits.peek().getPosition().getX() == pos.getX() && fruits.peek().getPosition().getY() == pos.getY()) {
                timer.interrupt();
                getPoints(fruits.peek());
                Messages.pacmanEat(fruits.peek());
                fruits.pop();
                create();
                return true;
            }
            return false;
        } else return false;
    }

    public void stopTimer () {
        timer.interrupt();
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
