package thread.cas;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class CasMainV3 {

    private static int THREAD_COUNT = 100;
    public static void main(String[] args) throws InterruptedException {

        AtomicInteger atomicInteger = new AtomicInteger(0);
        System.out.println("start value = "+atomicInteger);

        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                incrementAndGet(atomicInteger);
            }
        };

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread(runnable);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        int result = atomicInteger.get();
        System.out.println(atomicInteger.getClass().getSimpleName()+" result = " + result);

    }
    private static int incrementAndGet(AtomicInteger atomicInteger) {

        int getValue;
        boolean result;
        do{

            getValue = atomicInteger.get();
            sleep(10);
            log("getValue = "+getValue);
            result = atomicInteger.compareAndSet(getValue, getValue + 1);
            log("result:  "+result);

        }while(!result);

        return getValue +1;

    }
}
