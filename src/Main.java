import BankAccounts.Account;
import Commands.Command;
import Commands.DoTransfer;
import Commands.PrintMoney;
import Invoker.CommandInvoker;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Stack;

public class Main {


    public static void main(String[] args) {
        Account account1 = new Account(1000, "Nordea bank");
        Account account2 = new Account(1000, "Dansk bank");
        Account account3 = new Account(1000, "Jyske bank");

        Command transfer1To2 = new DoTransfer(account1, account2, 200);
        Command transfer2To3 = new DoTransfer(account2, account3, 350);
        Command transfer3To1 = new DoTransfer(account3, account1, 250);

        Command printMoney1 = new PrintMoney(account1, 1500);
        Command printMoney2 = new PrintMoney(account2, 500);
        Command printMoney3 = new PrintMoney(account3, 650);

        account1.printBalance();
        account2.printBalance();
        account3.printBalance();

        Stack<Command> commandStack = new Stack<>();

        CommandInvoker invoker = new CommandInvoker(printMoney1);
        invoker.executeCommand();
        commandStack.push(printMoney1);
        bankActions();

        invoker = new CommandInvoker(transfer3To1);
        invoker.executeCommand();
        commandStack.push(transfer3To1);
        bankActions();

        Command command = commandStack.pop();
        invoker = new CommandInvoker(command);
        invoker.unExecuteCommand();
        bankActions();

        invoker = new CommandInvoker(printMoney3);
        invoker.executeCommand();
        commandStack.push(printMoney3);
        bankActions();

        invoker = new CommandInvoker(transfer2To3);
        invoker.executeCommand();
        commandStack.push(transfer2To3);
        bankActions();

        invoker = new CommandInvoker(printMoney2);
        invoker.executeCommand();
        commandStack.push(printMoney2);
        bankActions();

        invoker = new CommandInvoker(printMoney2);
        invoker.executeCommand();
        commandStack.push(printMoney2);
        bankActions();

        command = commandStack.pop();
        invoker = new CommandInvoker(command);
        invoker.unExecuteCommand();
        bankActions();

        System.out.println("Rollback is coming...");
        while(!commandStack.isEmpty()) {
            bankActions();
            command = commandStack.pop();
            invoker = new CommandInvoker(command);
            invoker.unExecuteCommand();
        }

        account1.printBalance();
        account2.printBalance();
        account3.printBalance();

    }

    private static void bankActions() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }

    private void printBalances() {

    }



}