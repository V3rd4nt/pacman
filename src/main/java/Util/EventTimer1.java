package Util;
import Elements.*;

public class EventTimer1 extends Thread {
    private int time;
    private ElementHandler eh, eh2;
    private Element e;

    public EventTimer1(int time, ElementHandler eh, ElementHandler eh2, Element e) {
        this.time = time * 1000;
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
                        if (eh.getElements().contains(e)) {
                            Messages.remove(e);
                            eh.getElements().remove(e);
                        }
                        if (eh2 instanceof GhostHandler) {
                            ((GhostHandler) eh2).setVulnerable(true);
                            Thread.sleep(time);
                            ((GhostHandler) eh2).setVulnerable(false);
                        }
                        System.out.println(eh2.getNumberOfElements() + " GHOSTS left");
                        getBonus(eh2.getNumberOfElements());
                        break;
                    default:
                }
            }
            if (eh instanceof FruitHandler) {
                Thread.sleep(time);
                if (eh.getElements().contains(e)) {
                    Messages.remove(e);
                    eh.getElements().remove(e);
                }
            }
        } catch (InterruptedException e) {
            interrupt();
        }
    }

    protected void getBonus (int numberOfGhostsLeft) {
        switch (numberOfGhostsLeft) {
            case 1:
                Level.addScore(400);
                break;
            case 0:
                Level.addScore(800);
                break;
            default:
        }
    }
}

