package thread.bounded;

import static util.MyLogger.log;

public class ConsumerTask implements Runnable{

    private BoundedQueue queue;

    public ConsumerTask(BoundedQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        log("[소비시도]     ?  <- "+ queue);
        String data = queue.take();
        log("[소비완료]    "+ data+"  <- "+ queue);


    }
}
