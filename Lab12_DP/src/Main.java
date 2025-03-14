import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        TextEditor editor = new TextEditor();
        History history = new History();
        Scanner scanner = new Scanner(System.in);

        history.loadFromFile();

        while (true) {
            System.out.println("\n--- Text Editor Menu ---");
            System.out.println("1. Edit Content");
            System.out.println("2. Set Cursor Position");
            System.out.println("3. Add Selection");
            System.out.println("4. Clear Selections");
            System.out.println("5. Undo");
            System.out.println("6. Show Content");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter new content: ");
                    editor.setContent(scanner.nextLine());
                    history.backup(editor);
                    break;
                case 2:
                    System.out.print("Enter cursor position: ");
                    editor.setCursorPosition(scanner.nextInt());
                    history.backup(editor);
                    break;
                case 3:
                    System.out.print("Enter selection: ");
                    editor.addSelection(scanner.nextLine());
                    history.backup(editor);
                    break;
                case 4:
                    editor.clearSelections();
                    history.backup(editor);
                    break;
                case 5:
                    history.undo(editor);
                    break;
                case 6:
                    editor.displayState();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
