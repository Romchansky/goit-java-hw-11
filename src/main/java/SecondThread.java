import static java.lang.Thread.currentThread;



public class SecondThread implements Runnable {

    private FirstThread firstThread;
    private int currentTime;

    public SecondThread(FirstThread firstThread) {
        this.firstThread = firstThread;
    }

    @Override
    public void run() {

        currentTime = firstThread.getTime();

        while (!currentThread().isInterrupted()) {

            if (currentTime % 5 == 0 && currentTime != 0) {
                notifyAll();
                System.out.println(currentThread().getName() + " Прошло 5 секунд");
            }
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}






