using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;
using System.Net.Sockets;

namespace FileSender
{
    class Program
    {
        static void Main(string[] args)
        {
            // Get the file path to send
            Console.WriteLine("Enter the file path to send:");
            string filePath = Console.ReadLine();

            // Choose the encryption algorithm
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

            // Read the file
            string plainText = FileHandler.ReadFile(filePath);

            // Encrypt the file content
            string encryptedText = context.Encrypt(plainText);
            Console.WriteLine("File encrypted successfully!");

            // Send the encrypted file to the server
            try
            {
                
                using (TcpClient client = new TcpClient("127.0.0.1", 5000)) 
                using (NetworkStream stream = client.GetStream())
                using (StreamWriter writer = new StreamWriter(stream))
                {
                    writer.Write(encryptedText);
                    writer.Flush();
                    Console.WriteLine("File sent successfully!");
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error sending file: {ex.Message}");
            }
            Console.WriteLine("Press Enter to exit...");
            Console.ReadLine();
        }
    }
}
