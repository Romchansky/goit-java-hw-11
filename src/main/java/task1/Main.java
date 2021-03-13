package task1;


public class Main {
    /*
     *  #1
     * Напишите программу, которая каждую секунду отображает на экране данные о времени,
     * прошедшем от начала сессии (запуска программы).Другой ее поток выводит каждые 5 секунд сообщение
     * "Прошло 5 секунд".Предусмотрите возможность ежесекундного оповещения потока,
     * воспроизводящего сообщение, потоком, отсчитывающим время.
     *
     * */

    public static void main(String args[]) {


        // ex.1
        FirstThread firstThread = new FirstThread();
        SecondThread secondThread = new SecondThread(firstThread);

        firstThread.start();
        secondThread.start();




    }
}




