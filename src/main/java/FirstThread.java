

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

public class FirstThread implements Runnable {

    long currentSec;

    public synchronized int getTime() {
        return (int) currentSec;
    }

    @Override
    public void run() {

        long startSession = System.currentTimeMillis();

        while (!currentThread().isInterrupted()) {

            currentSec = (System.currentTimeMillis() - startSession) / 1000;
            System.out.println(currentThread().getName() + " second:" + currentSec);

            try {
                sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (currentSec == 15) {
                break;
            }
        }
        notifyAll();
    }
}



