package thread.sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BankAccountV5 implements BankAccount {


    private int balance;

    private final Lock lock = new ReentrantLock();

    public BankAccountV5(int initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public boolean withdraw(int amount) {

        log("거래 시작 : " + getClass().getSimpleName());

        if(!lock.tryLock()){
            log("진입 실패 : 이미 처리중인 작업이 있습니다.");
            return false;
        }

        //==임계 영역 시작 ==
        try {
            log("[검증 시작] 출금액: " + amount + ", 잔액 " + balance);

            //잔고가 출금액보다 적으면, 진행하면 안됨
            if (balance < amount) {
                log("[검증 실패] 출금액: " + amount + ", 잔액 " + balance);
                return false;
            }

            //잔고가 출금액보다 많으면, 진행
            log("[검증 완료] 출금액: " + amount + ", 잔액 " + balance);
            sleep(1000);
            balance -= amount;
            log("[출금 완료] 출금액: " + amount + ", 잔액 " + balance);
        } finally {
            lock.unlock();      //락 해제
        }

        //==임계 영역 종료 ==

        log("거래 종료 : ");

        return true;
    }

    @Override
    public int getBalance() {
        lock.lock();    //락걸기
        try {
            return balance;
        }finally {
            lock.unlock();
        }
    }
}
