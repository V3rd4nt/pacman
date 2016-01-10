package Pacman.Elements;

public class Position {

    private int x, y;

    // Level maximum size
    private static final int WIDTH = 30, HEIGHT = 20;

    public Position (int x, int y) {
        if (x <= 0) this.x = 0;
        if (x > 0 && x < WIDTH) this.x = x;
        if (x >= WIDTH) this.x = WIDTH;
        if (y <= 0) this.y = 0;
        if (y > 0 && y < HEIGHT) this.y = y;
        if (y >= HEIGHT) this.y = HEIGHT;
    }

    public int getX () {
        return x;
    }

    public int getY () {
        return y;
    }

    public boolean setX (int x) {

        if (x >= 0 && x <= WIDTH){
            this.x = x;
            return true;
        }
        return false;
    }

    public boolean setY (int y) {
        if (y >= 0 && y <= HEIGHT){
            this.y = y;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Position {" + "x = " + x + ", y = " + y + '}';
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    // not yet used
    public static Position getCenterPostition(){

        int x = WIDTH / 2;
        int y = HEIGHT / 2;
        return  new Position(x, y);
    }

    public static Position getStartingPos(){

        int x = WIDTH / 2;
        int y = (HEIGHT / 4) * 3;
        return  new Position(x, y);
    }
}
