import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        EncryptionContext context = new EncryptionContext();


        System.out.println("Select Encryption Algorithm: (1) AES, (2) DES, (3) Caesar Cipher");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            context.setEncryptionStrategy(new AESEncryptionStrategy());
        } else if (choice == 2) {
            context.setEncryptionStrategy(new DESEncryptionStrategy());
        } else if (choice == 3) {
            System.out.println("Enter Caesar Cipher Shift Value:");
            int shift = scanner.nextInt();
            context.setEncryptionStrategy(new CaesarCipherStrategy(shift));
        } else {
            System.out.println("Invalid choice");
            return;
        }


        System.out.println("Enter file path to encrypt:");
        String filePath = scanner.next();
        String content = new String(Files.readAllBytes(Paths.get(filePath)));


        System.out.println("Enter encryption key:");
        String key = scanner.next();


        byte[] encryptedData = context.encrypt(content, key);
        Files.write(Paths.get(filePath + ".enc"), encryptedData);
        System.out.println("File encrypted and saved as: " + filePath + ".enc");


        System.out.println("Decrypting the file for validation...");
        String decryptedData = context.decrypt(encryptedData, key);
        System.out.println("Decrypted content: " + decryptedData);
    }
}
