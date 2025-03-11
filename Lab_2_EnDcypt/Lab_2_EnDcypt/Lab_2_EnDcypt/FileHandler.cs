using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;


namespace Lab_2_EnDcypt
{
    public class FileHandler
    {
        public static string ReadFile(string filePath)
        {
            return File.ReadAllText(filePath);
        }

        public static void WriteFile(string filePath, string content)
        {
            File.WriteAllText(filePath, content);
        }
    }
}
