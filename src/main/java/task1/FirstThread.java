package task1;

public class FirstThread  extends Thread {

    int currentSec;

    public synchronized int getCurrentSec() {
        return currentSec;
    }

    @Override
    public void run() {

        while (!currentThread().isInterrupted()) {

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (this) {
                currentSec++;
            }
            System.out.println(currentThread().getName() + " second:" + currentSec);

            if (currentSec == 15) {
                break;
            }
        }
        System.out.println("finish 1");
    }
}



