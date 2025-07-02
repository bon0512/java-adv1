package thread.collection.simple.list;

public class SimpleListV1 {

    public static void main(String[] args) throws InterruptedException {
        SimpleList list = new BasicList();

        Runnable runnable1 = new Runnable() {

            @Override
            public void run() {
                list.add("A"); //첫번째 쓰레드;
            }
        };
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                list.add("B"); // 두번째 쓰레드
            }
        };

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println("list = "+list);
    }
}
