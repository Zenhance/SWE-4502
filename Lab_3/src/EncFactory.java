import java.util.Scanner;

public class EncFactory {

    public static EncryptionStrategy createEnc(){
        String help = "1.AES \n2.DES \n3.CAESAR";
        System.out.println("Choose the Encryption type\n" + help);

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        switch(choice){
            case 1:
                return new AES();
            case 2:
                return new DES();
            case 3:
                return new Caesar();
            default:
                return null;
        }
    }

    public static int getCaesarShift(){
        System.out.println("\nEnter the shift value for Caesar Cipher");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static String getString(){
        System.out.println("Enter the path to encrypt");
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();
        return TextReader.readFromTextFile(path);
    }
}
