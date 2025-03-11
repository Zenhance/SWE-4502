using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Security.Cryptography;

namespace Lab_2_EnDcypt
{
    public class DESEncryptionStrategy : IEncryptionStrategy
    {
        private readonly byte[] key;
        private readonly byte[] iv;

        public DESEncryptionStrategy()
        {
            // Example: generate key and iv
            key = Encoding.UTF8.GetBytes("abcdefgh");  // DES requires 8-byte key
            iv = Encoding.UTF8.GetBytes("12345678");  // DES requires 8-byte IV
        }

        public string Encrypt(string plainText)
        {
            using (DES des = DES.Create())
            {
                des.Key = key;
                des.IV = iv;
                ICryptoTransform encryptor = des.CreateEncryptor(des.Key, des.IV);
                byte[] encrypted = EncryptStringToBytes(plainText, encryptor);
                return Convert.ToBase64String(encrypted);
            }
        }

        public string Decrypt(string cipherText)
        {
            using (DES des = DES.Create())
            {
                des.Key = key;
                des.IV = iv;
                ICryptoTransform decryptor = des.CreateDecryptor(des.Key, des.IV);
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
