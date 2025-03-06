public class DepositCommand implements Command {

   private BankAccount account;
    private double amount;
    private String reference;


    public DepositCommand(BankAccount account, double amount, String reference){
        this.account = account;
        this.amount = amount;
        this.reference = reference;
    }

    @Override
    public void execute() {
        account.deposit(amount);
        System.out.println("Deposit of "+amount+" made to account "+account.getAccountNumber()+" "+reference);
    }







}
