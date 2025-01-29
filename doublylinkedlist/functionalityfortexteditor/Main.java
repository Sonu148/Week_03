package day_01.doublylinkedlist.functionalityfortexteditor;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Scanner scanner = new Scanner(System.in);
        String userInput;

        // Main loop for user interaction
        while (true) {
            System.out.println("\n--- Text Editor Menu ---");
            System.out.println("1. Add text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Display current text");
            System.out.println("5. Exit");
            System.out.print("Choose an action (1-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            // checking the user choice
            switch (choice) {
                case 1:
                    System.out.print("Enter the new text: ");
                    userInput = scanner.nextLine();
                    editor.addState(userInput);
                    break;

                case 2:
                    editor.undo();
                    break;

                case 3:
                    editor.redo();
                    break;

                case 4:
                    editor.displayState();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
