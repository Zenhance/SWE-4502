using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace FileReceiver
{
    public class FileHandler
    {
        public static void WriteFile(string filePath, string content)
        {
            File.WriteAllText(filePath, content);
        }
    }
}
