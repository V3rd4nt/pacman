package Pacman.Util;

import Pacman.Elements.*;

/**
 * EventTimer Class
 */
public class EventTimer extends Thread {
    private int time;
    private ElementHandler eh, eh2;
    private Element e;

    /**
     * Creates a new EventTimer
     * @param time thread sleep time
     * @param eh
     * @param eh2
     * @param e
     */
    public EventTimer(int time, ElementHandler eh, ElementHandler eh2, Element e, boolean testing) {
        if (testing) this.time = time*1000;
        else this.time = time*10;
        this.eh = eh;
        this.eh2 = eh2;
        this.e = e;
    }

    /**
     * Starts the EventTimer Thread
     *
     * Handles effects of the pills according to their effect times
     *
     * Changes Fruit positions after expired display times
     *
     * Changes Fruits after they were eaten by Pacman
     */
    @Override
    public void run() {
        try {
            if (eh instanceof PillHandler) {
                switch (((Pill)e).getType()) {
                    case POWER:
                        Messages.pacmanEat(e);
                        eh.getElements().remove(e);
                        if (eh2 instanceof GhostHandler) {
                            ((GhostHandler) eh2).setVulnerable(true);

                            // increased the time to give pacman a chance to actually eat a ghost
                            Thread.sleep(time);
                            ((GhostHandler) eh2).setVulnerable(false);
                        }
                        break;
                    default:
                }
            }
            if (eh instanceof FruitHandler) {
                while (!interrupted()) {
                    Thread.sleep(time);
                    e.setPosition(Movement.createRandomPosition());
                    Messages.appear(e);
                }
            }
        } catch (InterruptedException e) {
            interrupt();
        }
    }
}

