package thread.start.test;

public class StartTestMain {


    public static void main(String[] args) {

        CounterThread counterThread = new CounterThread();

        counterThread.start();
    }

}
