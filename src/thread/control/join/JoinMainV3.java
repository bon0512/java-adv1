package thread.control.join;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class JoinMainV3 {
    public static void main(String[] args) throws InterruptedException {

        log("Start");
        SumTask sumTask1 = new SumTask(1, 50);
        SumTask sumTask2 = new SumTask(51, 100);

        Thread thread1 = new Thread(sumTask1);
        Thread thread2 = new Thread(sumTask2);

        thread1.start();
        thread2.start();

        //스레드가 종료할때 까지 대기
        log("join() - main thread1 , thread2 종료될대까지 대기");
        thread1.join();
        thread2.join();
        log("main 스레드 대기 완료");

        
        log("task1.result = "+ sumTask1.result);
        log("task2.result = "+ sumTask2.result);

        int total = sumTask1.result + sumTask2.result;
        System.out.println("total = " + total);

        log("End");
    }

    static class SumTask implements Runnable{

        int startValue;
        int endValue;
        int result = 0;

        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public void run() {
            log("작업시작");
            sleep(2000);
            int sum = 0;
            for(int i = startValue;i<=endValue;i++){
                sum+=i;
            }
            result = sum;
            log("작업 완료 result = "+result);
        }
    }
}
