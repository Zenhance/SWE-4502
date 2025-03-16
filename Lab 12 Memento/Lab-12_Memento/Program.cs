using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_12_Memento
{
    public class Program
    {
        public static void Main(string[] args)
        {
            TextEditor editor = new TextEditor();
            History history = new History(editor);
            string filePath = "editorHistory.json";

            while (true)
            {
                Console.WriteLine("\n--- Text Editor ---");
                Console.WriteLine("1. Set Content");
                Console.WriteLine("2. Set Cursor Position");
                Console.WriteLine("3. Add Selection");
                Console.WriteLine("4. Display State");
                Console.WriteLine("5. Backup State");
                Console.WriteLine("6. Undo");
                Console.WriteLine("7. Save History to File");
                Console.WriteLine("8. Load History from File");
                Console.WriteLine("9. Exit");
                Console.Write("Choose an option: ");

                string choice = Console.ReadLine();
                Console.WriteLine();

                switch (choice)
                {
                    case "1":
                        Console.Write("Enter new content: ");
                        string content = Console.ReadLine();
                        editor.SetContent(content);
                        break;

                    case "2":
                        Console.Write("Enter cursor position: ");
                        if (int.TryParse(Console.ReadLine(), out int position))
                        {
                            editor.SetCursorPosition(position);
                        }
                        else
                        {
                            Console.WriteLine("Invalid input! Please enter a number.");
                        }
                        break;

                    case "3":
                        Console.Write("Enter selection: ");
                        string selection = Console.ReadLine();
                        editor.AddSelection(selection);
                        break;

                    case "4":
                        editor.DisplayState();
                        break;

                    case "5":
                        history.Backup();
                        Console.WriteLine("State backed up.");
                        break;

                    case "6":
                        history.Undo();
                        break;

                    case "7":
                        history.SaveToFile(filePath);
                        break;

                    case "8":
                        history.LoadFromFile(filePath);
                        break;

                    case "9":
                        Console.WriteLine("Exiting program...");
                        return;

                    default:
                        Console.WriteLine("Invalid choice! Please select a valid option.");
                        break;
                }
            }
        }
    }
}
