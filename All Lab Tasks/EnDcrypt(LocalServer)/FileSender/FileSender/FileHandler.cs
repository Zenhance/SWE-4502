using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace FileSender
{
    public class FileHandler
    {
        public static string ReadFile(string filePath)
        {
            return File.ReadAllText(filePath);
        }
    }
}
