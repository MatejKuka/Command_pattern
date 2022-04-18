package Commands;

import BankAccounts.Account;

public class PrintMoney implements Command{
    private Account maker;
    private int money;

    public PrintMoney(Account maker, int money) {
        this.maker = maker;
        this.money = money;
    }

    @Override
    public void execute() {
        maker.setBalance(maker.getBalance() + money);
        System.out.println(maker + "  printed " + money + " money");
    }

    @Override
    public void unExecute() {
        maker.setBalance(maker.getBalance() - money);
        System.out.println(maker + "  had to destroy " + money + " money");
    }

}
