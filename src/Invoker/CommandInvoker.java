package Invoker;


import Commands.Command;

public class CommandInvoker {
    private Command command;

    public CommandInvoker(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        this.command.execute();
    }

    public void unExecuteCommand() {
        this.command.unExecute();
    }

}
