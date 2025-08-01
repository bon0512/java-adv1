package thread.control.volatile1;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class VolatileFlagMain {

    public static void main(String[] args) {

        MyTask myTask = new MyTask();
        Thread thread = new Thread(myTask, "work");

        log("runFlag = " + myTask.runFlag);

        thread.start();
        sleep(1000);

        log("runFlag를 false로 변경");
        myTask.runFlag = false;
        log("runFlag = " + myTask.runFlag);
        log("main 종료");


    }

    static class MyTask implements Runnable {

        volatile boolean runFlag = true;


        @Override
        public void run() {
            log("task 시작");

            while (runFlag) {
                //runFlag가 false로 변하면 탈출

            }
            log("task 종료");
        }
    }
}
