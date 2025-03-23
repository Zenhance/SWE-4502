using TextEditor;

Console.WriteLine("=== Text Editor ===\n");

var editor = new TextEditor.TextEditor();
var history = new History(editor);

bool running = true;
while (running)
{
    Console.WriteLine("\nChoose an action:");
    Console.WriteLine("1. Set content");
    Console.WriteLine("2. Move cursor");
    Console.WriteLine("3. Add selection");
    Console.WriteLine("4. Clear selections");
    Console.WriteLine("5. Display current state");
    Console.WriteLine("6. Save state (create memento)");
    Console.WriteLine("7. Undo (restore previous state)");
    Console.WriteLine("8. Save state to file");
    Console.WriteLine("9. Load state from file");
    Console.WriteLine("0. Exit");

    Console.Write("\nYour choice: ");
    string choice = Console.ReadLine();

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
                Console.WriteLine("Invalid position. Please enter a number.");
            }

            break;

        case "3":
            Console.Write("Enter selection text: ");
            string selection = Console.ReadLine();
            editor.AddSelection(selection);
            break;

        case "4":
            editor.ClearSelections();
            break;

        case "5":
            editor.DisplayState();
            break;

        case "6":
            history.Backup();
            break;

        case "7":
            history.Undo();
            break;

        case "8":
            Console.Write("Enter file path to save: ");
            string savePath = Console.ReadLine();
            history.SaveToFile(savePath);
            break;

        case "9":
            Console.Write("Enter file path to load: ");
            string loadPath = Console.ReadLine();
            history.LoadFromFile(loadPath);
            break;

        case "0":
            running = false;
            break;

        default:
            Console.WriteLine("Invalid choice. Please try again.");
            break;
    }
}

Console.WriteLine("\nThanks for using the Text Editor!");