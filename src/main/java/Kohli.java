import java.util.Scanner;

public class Kohli {
    private static final int MAX_TASKS = 100;
    private static String[] tasks = new String[MAX_TASKS];
    private static int taskCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display the Kohli welcome message
        System.out.println("____________________________________________________________");
        System.out.println("Hello! I'm Kohli\nWhat can I do for you?");
        System.out.println("____________________________________________________________");

        while (true) {
            // Read user input
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("bye")) {
                // Exit the chatbot
                System.out.println("____________________________________________________________");
                System.out.println("Bye. Hope to see you again soon!");
                System.out.println("____________________________________________________________");
                break;
            } else if (userInput.equalsIgnoreCase("list")) {
                // Display the stored tasks
                System.out.println("____________________________________________________________");
                for (int i = 0; i < taskCount; i++) {
                    System.out.println((i + 1) + ". " + tasks[i]);
                }
                System.out.println("____________________________________________________________");
            } else {
                // Store user input as a task
                if (taskCount < MAX_TASKS) {
                    tasks[taskCount] = userInput;
                    taskCount++;
                    System.out.println("____________________________________________________________");
                    System.out.println("added: " + userInput);
                    System.out.println("____________________________________________________________");
                } else {
                    System.out.println("____________________________________________________________");
                    System.out.println("Task list is full!");
                    System.out.println("____________________________________________________________");
                }
            }
        }

        // Close the scanner
        scanner.close();
    }
}



