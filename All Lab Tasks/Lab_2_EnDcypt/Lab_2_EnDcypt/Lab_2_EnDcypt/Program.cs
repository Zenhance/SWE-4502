using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_2_EnDcypt
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Select Encryption Algorithm: 1. AES  2. DES  3. Caesar Cipher");
            int choice = int.Parse(Console.ReadLine());

            EncryptionContext context = new EncryptionContext();
            switch (choice)
            {
                case 1:
                    context.SetEncryptionStrategy(new AESEncryptionStrategy());
                    break;
                case 2:
                    context.SetEncryptionStrategy(new DESEncryptionStrategy());
                    break;
                case 3:
                    Console.WriteLine("Enter the shift value for Caesar Cipher:");
                    int shift = int.Parse(Console.ReadLine());
                    context.SetEncryptionStrategy(new CaesarCipherStrategy(shift));
                    break;
                default:
                    Console.WriteLine("Invalid choice");
                    return;
            }

            // Read file
            Console.WriteLine("Enter the input file path:");
            string inputFilePath = Console.ReadLine();
            string plainText = FileHandler.ReadFile(inputFilePath);

            // Encrypt file
            string encryptedText = context.Encrypt(plainText);
            Console.WriteLine("\nEnter the output file path to save encrypted data:");
            string encryptedFilePath = Console.ReadLine();
            FileHandler.WriteFile(encryptedFilePath, encryptedText);
            Console.WriteLine("\nFile encrypted successfully!");



            Console.WriteLine("\n");

            Console.WriteLine(encryptedText);

            // Decrypt file
            string decryptedText = context.Decrypt(encryptedText);
            Console.WriteLine("\nDecrypted text:\n");
            Console.WriteLine(decryptedText);

            Console.ReadLine();
        }
    }
}
