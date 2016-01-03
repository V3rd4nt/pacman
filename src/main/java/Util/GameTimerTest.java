package Util;
import Elements.*;


public class GameTimerTest extends Thread {
    private Level level;

    public GameTimerTest(Level level) {
        this.level = level;
    }

    public void run() {

        //while (!interrupted()) {
            try {
                Thread.sleep(2000);
                level.eat(new Position (6,2));
                Thread.sleep(3000);
                level.eat(new Position (6,1));
                Thread.sleep(1000);
                level.eat(new Position (6,4));
                Thread.sleep(1000);
                level.eat(new Position (6,3));

            } catch (InterruptedException e) {
                interrupt();
            }
        //}
    }
}
