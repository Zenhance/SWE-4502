using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;
using System.Net;
using System.Net.Sockets;

namespace FileReceiver
{
    class Program
    {
        static void Main(string[] args)
        {
            TcpListener server = new TcpListener(IPAddress.Any, 5000);
            server.Start();
            Console.WriteLine("Waiting for a connection...");

            using (TcpClient client = server.AcceptTcpClient())
            using (NetworkStream stream = client.GetStream())
            using (StreamReader reader = new StreamReader(stream))
            {
                string encryptedText = reader.ReadToEnd();
                Console.WriteLine("File received successfully!");

                // Now decrypt the text using EncryptionContext
                Console.WriteLine("Select Decryption Algorithm: 1. AES  2. DES  3. Caesar Cipher");
                int choice = int.Parse(Console.ReadLine());
                EncryptionContext context = new EncryptionContext();

                switch (choice)
                {
                    case 1:
                        string keyInput, ivInput;
                        do
                        {
                            Console.WriteLine("Enter AES Key (16 characters):");
                            keyInput = Console.ReadLine();
                            Console.WriteLine("Enter AES IV (16 characters):");
                            ivInput = Console.ReadLine();

                            if (keyInput.Length != 16 || ivInput.Length != 16)
                            {
                                Console.WriteLine("Invalid Key or IV. Please Enter the valid one!.");
                            }
                        }
                        while (keyInput.Length != 16 || ivInput.Length != 16); // Keep asking until valid input is provided

                        context.SetEncryptionStrategy(new AESEncryptionStrategy(keyInput, ivInput));
                        break;
                    case 2:
                        string key, iv;
                        do
                        {
                            Console.WriteLine("Enter DES Key (8 characters):");
                            key = Console.ReadLine();
                            Console.WriteLine("Enter DES IV (8 characters):");
                            iv = Console.ReadLine();

                            if (key.Length != 8 || iv.Length != 8)
                            {
                                Console.WriteLine("Invalid Key or IV. Please Enter the valid one!.");
                            }
                        }
                        while (key.Length != 8 || iv.Length != 8); // Keep asking until valid input is provided
                        context.SetEncryptionStrategy(new DESEncryptionStrategy(key,iv));
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

                // Decrypt and save the original content
                string decryptedText = context.Decrypt(encryptedText);

                // Ask the user where to save the decrypted file
                Console.WriteLine("Enter the file path to save the decrypted file (e.g., C:\\path\\to\\decryptedFile.txt):");
                string outputFilePath = Console.ReadLine();

                // Save the decrypted file
                FileHandler.WriteFile(outputFilePath, decryptedText);
                Console.WriteLine($"File decrypted and saved as '{outputFilePath}'.");
            }
            Console.WriteLine("Press Enter to exit...");
            Console.ReadLine();
        }
    }
}
