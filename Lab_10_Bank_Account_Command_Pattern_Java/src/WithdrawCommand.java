class WithdrawCommand implements Command {
    private final BankAccount account;
    private final double amount;

    public WithdrawCommand(BankAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() {
        if (account.withdraw(amount)) {
            System.out.println("Withdrew " + amount + " from account " + account.getId());
        } else {
            System.out.println("Withdrawal failed: Insufficient funds");
        }
    }
}