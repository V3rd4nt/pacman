package Util;

import Elements.Position;
import java.util.Random;

public class Movement {

    public static Position createRandomPosition () {
        return new Position (new Random().nextInt(Position.getWIDTH()), new Random().nextInt(Position.getHEIGHT()));
    }

    public static Position createNextPositionFrom (Position pos) {
        boolean moved;
        Random rndNr = new Random();
        //0 = right, 1 = Up, 2 = left, 3 = bottom
        do {
            moved = false;
            int direction = rndNr.nextInt(1000);
            direction /= 250;
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
