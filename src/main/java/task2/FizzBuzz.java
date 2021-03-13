package task2;

import java.util.function.IntConsumer;

class FizzBuzz {

    private int endingValue;
    private int currentValue = 1;

    public FizzBuzz(int number) {
        this.endingValue = number;
    }

    public synchronized void fizz(Runnable printFizz) {

        while (currentValue <= endingValue) {
            if (currentValue % 3 == 0 && currentValue % 5 != 0) {
                printFizz.run();
                currentValue++;
                notifyAll();
            } else {
                waitingThread();
            }
        }
    }

    public synchronized void buzz(Runnable printBuzz) {

        while (currentValue <= endingValue) {
            if (currentValue % 3 != 0 && currentValue % 5 == 0) {
                printBuzz.run();
                currentValue++;
                notifyAll();
            } else {
                waitingThread();
            }
        }
    }

    public synchronized void fizzbuzz(Runnable printFizzBuzz) {

        while (currentValue <= endingValue) {
            if (currentValue % 15 == 0) {
                printFizzBuzz.run();
                currentValue++;
                notifyAll();
            } else {
                waitingThread();
            }
        }
    }

    public synchronized void number(IntConsumer printNumber) {

        while (currentValue <= endingValue) {
            if (currentValue % 3 != 0 && currentValue % 5 != 0) {
                printNumber.accept(currentValue);
                currentValue++;
                notifyAll();
            } else {
                waitingThread();
            }
        }
    }

    public void waitingThread() {

        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

