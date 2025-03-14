import java.util.Scanner;

public class Program
{
    public static void main(String[] args) {
        System.out.println("Text Editor Application");
        System.out.println("======================");

        // Initialize components
        TextEditor editor = new TextEditor();
        History history = new History(editor);
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("\nCommands: ");
            System.out.println("1. Set content");
            System.out.println("2. Set cursor position");
            System.out.println("3. Add selection");
            System.out.println("4. Clear selections");
            System.out.println("5. Show current state");
            System.out.println("6. Save state (backup)");
            System.out.println("7. Undo (restore previous state)");
            System.out.println("8. Save history to file");
            System.out.println("9. Load history from file");
            System.out.println("0. Exit");
            System.out.print("\nEnter command: ");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.print("Enter new content: ");
                    String content = scanner.nextLine();
                    editor.setContent(content);
                    System.out.println("Content updated.");
                    break;

                case "2":
                    System.out.print("Enter cursor position: ");
                    try {
                        int position = Integer.parseInt(scanner.nextLine());
                        editor.setCursorPosition(position);
                        System.out.println("Cursor position updated.");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid position. Please enter a number.");
                    }
                    break;

                case "3":
                    System.out.print("Enter selection text: ");
                    String selection = scanner.nextLine();
                    editor.addSelection(selection);
                    System.out.println("Selection added.");
                    break;

                case "4":
                    editor.clearSelections();
                    System.out.println("Selections cleared.");
                    break;

                case "5":
                    editor.displayState();
                    break;

                case "6":
                    history.backup();
                    break;

                case "7":
                    history.undo();
                    break;

                case "8":
                    System.out.print("Enter file path to save: ");
                    String savePath = scanner.nextLine();
                    history.saveToFile(savePath);
                    break;

                case "9":
                    System.out.print("Enter file path to load: ");
                    String loadPath = scanner.nextLine();
                    history.loadFromFile(loadPath);
                    history.setEditor(editor);  // Reset the editor reference after loading
                    break;

                case "0":
                    running = false;
                    System.out.println("Exiting application.");
                    break;

                default:
                    System.out.println("Unknown command. Please try again.");
            }
        }

        scanner.close();
    }
}
