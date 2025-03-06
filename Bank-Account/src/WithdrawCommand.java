public class WithdrawCommand implements  Command {

    private BankAccount account;
    private double amount;
    private String reference;

    public WithdrawCommand(BankAccount account, double amount, String reference){
        this.account = account;
        this.amount = amount;
        this.reference = reference;
    }

    @Override
    public void execute() {
        account.withdraw(amount);
        System.out.println("Withdrawal of "+amount+" made from account "+account.getAccountNumber()+" "+reference);
    }

}
