package thread.start;

public class DemonThreadMain {

    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName() + ": main() start");

        DemonThread demonThread = new DemonThread();
        demonThread.setDaemon(true);
        demonThread.start();

        System.out.println(Thread.currentThread().getName() + ": main() end");

    }

    static class DemonThread extends Thread {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ": main() run");

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
