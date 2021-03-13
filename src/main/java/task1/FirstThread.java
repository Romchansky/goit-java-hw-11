package task1;

public class FirstThread extends Thread {

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

            // если здесь поставить 15 то второй поток №2 завершится на 2 секунды позже первого №1

            if (currentSec == 16) {
                break;
            }
        }
        System.out.println("Finish - " + Thread.currentThread().getName());
    }
}



