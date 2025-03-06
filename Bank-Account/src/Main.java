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



        }
    }
}
