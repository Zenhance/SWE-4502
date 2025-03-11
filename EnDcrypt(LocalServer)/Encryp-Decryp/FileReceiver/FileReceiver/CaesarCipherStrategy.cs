using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FileReceiver
{
    public class CaesarCipherStrategy : IEncryptionStrategy
    {
        private readonly int shift;

        public CaesarCipherStrategy(int shift)
        {
            this.shift = shift;
        }

        public string Encrypt(string plainText)
        {
            return ShiftText(plainText, shift);
        }

        public string Decrypt(string cipherText)
        {
            return ShiftText(cipherText, 26 - shift);
        }

        private string ShiftText(string input, int shift)
        {
            char[] buffer = input.ToCharArray();
            for (int i = 0; i < buffer.Length; i++)
            {
                char letter = buffer[i];
                if (char.IsLetter(letter))
                {
                    char offset = char.IsUpper(letter) ? 'A' : 'a';
                    letter = (char)((letter + shift - offset) % 26 + offset);
                }
                buffer[i] = letter;
            }
            return new string(buffer);
        }
    }
}
