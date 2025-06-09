package thread.bounded;

import static util.MyLogger.log;

public class ProducerTask implements Runnable{

    private BoundedQueue queue;

    public ProducerTask(BoundedQueue queue, String request) {
        this.queue = queue;
        this.request = request;
    }

    private String request;


    @Override
    public void run() {
        log("[생산 시도] "+request +" ->"+queue);
        queue.put(request);
        log("[생산 완료] "+request +" ->"+queue);

    }
}
