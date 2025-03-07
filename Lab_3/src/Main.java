import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while(true){
            EncryptionStrategy enc = EncFactory.createEnc();
            String plainText = EncFactory.getString();
            try {
                String encryptedText = enc.encryptData(plainText);
                TextWriter.writeToTextFile(encryptedText);
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("Do you want to continue? (Y/N)");
            Scanner sc = new Scanner(System.in);
            String choice = sc.nextLine();
            if(choice.equalsIgnoreCase("N")){
                break;
            }
        }
    }
}