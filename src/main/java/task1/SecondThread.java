package task1;

public class SecondThread extends Thread {

    FirstThread firstThread;
    int currentSec;

    public SecondThread(FirstThread firstThread) {
        this.firstThread = firstThread;
    }

    @Override
    public void run() {

        while (firstThread.isAlive()) {
            try {

                currentSec = firstThread.getCurrentSec();

                if (currentSec % 5 == 0 && currentSec != 0) {
                    System.out.println(currentThread().getName() + " Прошло 5 секунд");
                    sleep(2000);
                }
            } catch (IllegalStateException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("finish 2");
    }
}







