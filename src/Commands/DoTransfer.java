package Commands;

import BankAccounts.Account;

public class DoTransfer implements Command{
    private Account source;
    private Account reciever;
    private int money;


    public DoTransfer(Account source, Account reciever, int money) {
        this.source = source;
        this.reciever = reciever;
        this.money = money;
    }

    @Override
    public void execute() {
        if (source.getBalance() > money) {
            source.setBalance(source.getBalance() - money);
            reciever.setBalance(reciever.getBalance() + money);
            System.out.println(source + " sent " + money + " to " + reciever);
        }
    }

    @Override
    public void unExecute() {
        source.setBalance(source.getBalance() + money);
        reciever.setBalance(reciever.getBalance() - money);
        System.out.println(source + " retrieved " + money + " from " + reciever);
    }
}
