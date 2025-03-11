using System;
using System.Security.Cryptography;
using System.Text;

namespace Lab_2_EnDcypt
{
    public class AESEncryptionStrategy : IEncryptionStrategy
    {
        private readonly byte[] key;  
        private readonly byte[] iv;   

        public AESEncryptionStrategy()
        {
            // Example of using a fixed 16-byte key and IV.
            key = Encoding.UTF8.GetBytes("abcdefghijklmnop");  // 16-byte key (128-bit)
            iv = Encoding.UTF8.GetBytes("1234567890123456");   // 16-byte IV
        }

        // Encrypt method: Encrypts plain text into ciphertext using AES
        public string Encrypt(string plainText)
        {
            using (Aes aes = Aes.Create())  
            {
                aes.Key = key;  
                aes.IV = iv;    

                ICryptoTransform encryptor = aes.CreateEncryptor(aes.Key, aes.IV);

                byte[] encrypted = EncryptStringToBytes(plainText, encryptor);

                return Convert.ToBase64String(encrypted);
            }
        }

        public string Decrypt(string cipherText)
        {
            using (Aes aes = Aes.Create())  // Creates a new AES object
            {
                aes.Key = key;  // Assigns the key for AES decryption
                aes.IV = iv;    // Assigns the IV for AES decryption

                ICryptoTransform decryptor = aes.CreateDecryptor(aes.Key, aes.IV);

                byte[] encryptedBytes = Convert.FromBase64String(cipherText);

                return DecryptStringFromBytes(encryptedBytes, decryptor);
            }
        }

        private byte[] EncryptStringToBytes(string plainText, ICryptoTransform encryptor)
        {
            byte[] plainBytes = Encoding.UTF8.GetBytes(plainText);

            return encryptor.TransformFinalBlock(plainBytes, 0, plainBytes.Length);
        }

        private string DecryptStringFromBytes(byte[] cipherBytes, ICryptoTransform decryptor)
        {
            byte[] decryptedBytes = decryptor.TransformFinalBlock(cipherBytes, 0, cipherBytes.Length);

            return Encoding.UTF8.GetString(decryptedBytes);
        }
    }
}
