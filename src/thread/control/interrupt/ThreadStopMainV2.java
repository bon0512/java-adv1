package thread.control.interrupt;

import javax.swing.text.TableView;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ThreadStopMainV2 {

    public static void main(String[] args) {

        MyTask myTask = new MyTask();
        Thread thread = new Thread(myTask, "work");
        thread.start();

        sleep(4000);
        log("작업 중단 지시 thread.interrupt()");
        thread.interrupt();
        log("work 스레드 인터럽트 상태 1 = "+ thread.isInterrupted());




    }

    static class MyTask implements Runnable{

        volatile boolean runFlag = true;

        @Override
        public void run() {

            try {
                while (runFlag) {
                    log("작업중");
                    Thread.sleep(3000);
                }
            }catch (InterruptedException e) {
                    log("work 스레드 인터럽트 상태 2 = "+ Thread.currentThread().isInterrupted());
                    log("interrupt message = "+e.getMessage());
                    log("state = "+Thread.currentThread().getState());
            }


            log("자원 정리");
            log("자원 종료");
        }
    }
}
