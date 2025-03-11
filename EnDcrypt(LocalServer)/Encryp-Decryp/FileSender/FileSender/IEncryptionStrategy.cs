using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FileSender
{
    public interface IEncryptionStrategy
    {
        string Encrypt(string plainText);
        string Decrypt(string cipherText);
    }
}
