package Collectables;

/**
 * Created by armor on 25.12.2015.
 */
public class Position {

    private int x, y;
    private final int WIDTH = 1024, HEIGHT = 768;

    public Position (int x, int y) {
        if (x <= 0) this.x = 0;
        if (x > 0 && x < WIDTH) this.x = x;
        if (x >= WIDTH) this.x = WIDTH;
        if (y <= 0) this.y = 0;
        if (y > 0 && x < HEIGHT) this.y = y;
        if (y >= HEIGHT) this.y = HEIGHT;
    }

    public int getX () {
        return x;
    }

    public int getY () {
        return y;
    }
}
