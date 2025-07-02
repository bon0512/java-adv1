package thread.collection.simple.list;

import thread.start.test.StartTestMain2;

import javax.swing.*;

import static util.MyLogger.log;

public class SimpleListV2 {

    public static void main(String[] args) throws InterruptedException {

        //test(new BasicList());
        //test(new SyncList());
        test(new SyncProxyList(new BasicList()));
    }


    private static void test(SimpleList list) throws InterruptedException {

        Runnable runnableA = new Runnable() {
            @Override
            public void run() {
                list.add("A");
                log("Thread-1 : list.add(A)");
            }
        };

        Runnable runnableB = new Runnable() {
            @Override
            public void run() {
                list.add("B");
                log("Thread-2 : list.add(B)");
            }
        };
        Thread thread1 = new Thread(runnableA, "Thread-1");
        Thread thread2 = new Thread(runnableB, "Thread-2");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();


        log(list);


    }


}
