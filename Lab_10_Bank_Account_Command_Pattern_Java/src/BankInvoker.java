// Invoker
class BankInvoker {
    private final Queue<Command> commandQueue = new LinkedList<>();

    public void setCommand(Command command) {
        commandQueue.add(command);
    }

    public void executeCommands() {
        while (!commandQueue.isEmpty()) {
            Command command = commandQueue.poll();
            command.execute();
        }
    }
}