package thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static thread.executor.ExecutorUtils.printState;
import static util.MyLogger.log;

public class ExecutorBasicMain {
    public static void main(String[] args) {

        ExecutorService es = new ThreadPoolExecutor(2,2,0, TimeUnit.MILLISECONDS,new LinkedBlockingDeque<>());
        log("== 초기상태 ==");
        printState(es);
    }
}
