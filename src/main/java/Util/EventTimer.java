package Util;
import Elements.*;

public class EventTimer extends Thread {
    private int time;
    private ElementHandler eh, eh2;
    private Element e;

    public EventTimer(int time, ElementHandler eh, ElementHandler eh2, Element e) {
        this.time = time;
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
                            Thread.sleep(time);
                            ((GhostHandler) eh2).setVulnerable(false);
                        }
                        System.out.println(eh2.getNumberOfElements() + " ghosts left on the playing field");
                        getBonus(eh2.getNumberOfElements());
                        break;
                    default:
                }
            }
            if (eh instanceof FruitHandler) {
                while (true) {
                    //System.out.println("Show " + e.toString() + " for " + time + " seconds");
                    Thread.sleep(time);
                    //Messages.vanish(e);
                    e.setPosition(Movement.createRandomPosition());
                    //Messages.position(e);
                }
            }
        } catch (InterruptedException e) {
            interrupt();
        }
    }

    protected void getBonus (int numberOfGhostsLeft) {
        switch (numberOfGhostsLeft) {
            case 1:
                System.out.print("Bonus ");
                Level.addScore(400);
                break;
            case 0:
                System.out.print("Bonus ");
                Level.addScore(800);
                break;
            default:
        }
    }
}

