import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello World");

        Scanner scanner = new Scanner(System.in);
        CommandInvoker commandInvoker = new CommandInvoker();

        while(true) {
            System.out.println("\n1. Create Account\n2. Deposit\n3. Withdraw\n4. View Balance\n5. Transaction History\n6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter initial deposit: ");
                    double initialDeposit = scanner.nextDouble();
                    scanner.nextLine();
                    commandInvoker.executeCommand(new CreateAccountCommand(commandInvoker.getAccounts(), customerName, initialDeposit));
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    String accountNumber = scanner.nextLine();
                    BankAccount account = commandInvoker.getAccount(accountNumber);
                    if (account == null) {
                        System.out.println("Account not found: " + accountNumber);
                        break;
                    }
                    System.out.print("Enter amount to deposit: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter reference: ");
                    String reference = scanner.nextLine();
                    commandInvoker.executeCommand(new DepositCommand(account, amount, reference));
                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    System.out.print("Enter amount to withdraw: ");
                    amount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter reference: ");
                    reference = scanner.nextLine();
                    commandInvoker.executeCommand(new WithdrawCommand(commandInvoker.getAccount(accountNumber), amount,reference));
                    break;
                case 4:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    System.out.println("Balance: " + commandInvoker.getAccount(accountNumber).getBalance());
                    break;
                case 5:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    commandInvoker.printTransactionHistory(accountNumber);
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }



        }
    }
}
