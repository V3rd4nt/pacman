package Pacman.Util;

import Pacman.Elements.*;

public class EventTimer extends Thread {
    private int time;
    private ElementHandler eh, eh2;
    private Element e;

    public EventTimer(int time, ElementHandler eh, ElementHandler eh2, Element e) {
        this.time = time*10;
        this.eh = eh;
        this.eh2 = eh2;
        this.e = e;
    }

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
                            Thread.sleep(time*100);
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

