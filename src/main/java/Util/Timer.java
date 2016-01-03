package Util;

import Elements.*;

public class Timer extends Thread {
    private int time;
    private ElementHandler eh;
    private Element e;

    public Timer (int time, ElementHandler eh, Element e) {
        this.time = time*1000;
        this.eh = eh;
        this.e = e;
    }

    @Override
    public void run () {
        try {
            Thread.sleep(time);
            if (eh instanceof FruitHandler) {
                if (eh.getElements().contains(e)) {
                    Messages.disappear(e);
                    eh.getElements().remove(e);
                }
            }
            this.interrupt();

        } catch (InterruptedException e) {
            interrupt();
        }
    }
}
