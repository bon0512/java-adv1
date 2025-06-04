package thread.sync;

public class withDrawTask implements Runnable{

    private BankAccount account;
    private int amount;

    public withDrawTask(BankAccount account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.withdraw(amount);
    }
}
