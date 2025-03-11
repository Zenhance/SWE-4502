using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FileSender
{
    public class EncryptionContext
    {
        private IEncryptionStrategy _encryptionStrategy;

        public void SetEncryptionStrategy(IEncryptionStrategy encryptionStrategy)
        {
            _encryptionStrategy = encryptionStrategy;
        }

        public string Encrypt(string plainText)
        {
            return _encryptionStrategy.Encrypt(plainText);
        }
    }
}
