package day_01.circularlinkedlist.taskscheduler;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create an instance of TaskScheduler to manage tasks
        TaskScheduler scheduler = new TaskScheduler();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display the menu options to the user
            System.out.println("\n--- Task Scheduler Menu ---");
            System.out.println("1. Add task at beginning");
            System.out.println("2. Add task at end");
            System.out.println("3. Add task at specific position");
            System.out.println("4. Remove task by Task ID");
            System.out.println("5. View next task");
            System.out.println("6. Display all tasks");
            System.out.println("7. Search task by priority");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            // Switch statement to handle user choices
            switch (choice) {
                case 1:
                    System.out.print("Enter task ID, name, priority, and due date: ");
                    int taskId1 = scanner.nextInt();
                    scanner.nextLine();
                    String taskName1 = scanner.nextLine();
                    int priority1 = scanner.nextInt();
                    scanner.nextLine();
                    String dueDate1 = scanner.nextLine();
                    scheduler.addTaskAtBeginning(taskId1, taskName1, priority1, dueDate1);
                    break;

                case 2:
                    System.out.print("Enter task ID, name, priority, and due date: ");
                    int taskId2 = scanner.nextInt();
                    scanner.nextLine();
                    String taskName2 = scanner.nextLine();
                    int priority2 = scanner.nextInt();
                    scanner.nextLine();
                    String dueDate2 = scanner.nextLine();
                    scheduler.addTaskAtEnd(taskId2, taskName2, priority2, dueDate2);
                    break;

                case 3:
                    System.out.print("Enter task ID, name, priority, due date, and position: ");
                    int taskId3 = scanner.nextInt();
                    scanner.nextLine();
                    String taskName3 = scanner.nextLine();
                    int priority3 = scanner.nextInt();
                    scanner.nextLine();
                    String dueDate3 = scanner.nextLine();
                    int position = scanner.nextInt();
                    scheduler.addTaskAtPosition(taskId3, taskName3, priority3, dueDate3, position);
                    break;

                case 4:
                    System.out.print("Enter task ID to remove: ");
                    int taskIdToRemove = scanner.nextInt();
                    scheduler.removeTaskById(taskIdToRemove);
                    break;

                case 5:
                    scheduler.viewNextTask();
                    break;

                case 6:
                    scheduler.displayAllTasks();
                    break;

                case 7:
                    System.out.print("Enter priority to search: ");
                    int prioritySearch = scanner.nextInt();
                    scheduler.searchByPriority(prioritySearch);
                    break;

                case 8:
                    System.out.println("Exiting Task Scheduler.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
