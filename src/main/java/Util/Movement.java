package Util;

import Elements.Position;

import java.util.Random;

public class Movement {

    public enum Direction{
        Left,
        Right,
        Up,
        Down
    }

    public static Position createRandomPosition () {
        int x = new Random().nextInt(Position.getWIDTH());
        int y = new Random().nextInt(Position.getHEIGHT());
        return new Position (x,y);
    }

    public static Position createNextPositionFrom (Position current) {
        Position pos = current;
        boolean moved = false;
        Random rndNr = new Random();
        //0 = right, 1 = Up, 2 = left, 3 = bottom
        do {
            moved = false;
            int direction = rndNr.nextInt(4);
            switch (direction){
                case 0:
                    moved = pos.setX(pos.getX() - 1);
                    break;
                case 1:
                    moved = pos.setY(pos.getY() - 1);
                    break;
                case 2:
                    moved = pos.setX(pos.getX() + 1);
                    break;
                case 3:
                    moved= pos.setY(pos.getY() + 1);
                    break;
            }
        } while (!moved);


        return pos;
    }

}
