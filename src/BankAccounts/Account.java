package BankAccounts;

public class Account {
    private int balance;
    private String name;

    public Account(int balance, String name) {
        this.balance = balance;
        this.name = name;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printBalance(){
        System.out.println(name + " : " + balance);
    }

    @Override
    public String toString() {
        return name;
    }
}
