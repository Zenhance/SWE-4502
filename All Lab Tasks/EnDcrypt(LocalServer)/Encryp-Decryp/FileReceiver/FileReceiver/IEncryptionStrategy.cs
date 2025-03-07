using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FileReceiver
{
    public interface IEncryptionStrategy
    {
        string Encrypt(string plainText);
        string Decrypt(string cipherText);
    }
}
