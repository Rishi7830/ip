import java.util.Scanner;

public class Kohli {
    // Maximum number of tasks
    private static final int MAX_TASKS = 100;
    private static String[] tasks = new String[MAX_TASKS];
    private static boolean[] taskStatus = new boolean[MAX_TASKS];
    private static int taskCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display the Kohli welcome message
        System.out.println("____________________________________________________________");
        System.out.println("Hello! I'm Kohli \nWhat can I do for you?");
        System.out.println("____________________________________________________________");

        while (true) {
            // Read the input from the user
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("bye")) {
                // User exits the chatbot
                System.out.println("____________________________________________________________");
                System.out.println("Bye. Hope to see you again soon!");
                System.out.println("____________________________________________________________");
                break;
            } else if (userInput.equalsIgnoreCase("list")) {
                // To display the list of tasks
                System.out.println("____________________________________________________________");
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < taskCount; i++) {
                    String status = taskStatus[i] ? "[X]" : "[ ]";
                    System.out.println((i + 1) + "." + status + " " + tasks[i]);
                }
                System.out.println("____________________________________________________________");
            } else if (userInput.startsWith("mark ")) {
                // Mark the task number input by user as done
                int taskIndex = Integer.parseInt(userInput.split(" ")[1]) - 1;
                if (taskIndex >= 0 && taskIndex < taskCount) {
                    taskStatus[taskIndex] = true;
                    System.out.println("____________________________________________________________");
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println("  [X] " + tasks[taskIndex]);
                    System.out.println("____________________________________________________________");
                } else {
                    System.out.println("____________________________________________________________");
                    System.out.println("Invalid task number.");
                    System.out.println("____________________________________________________________");
                }
            } else if (userInput.startsWith("unmark ")) {
                // To unmark the task number chosen by the user
                int taskIndex = Integer.parseInt(userInput.split(" ")[1]) - 1;
                if (taskIndex >= 0 && taskIndex < taskCount) {
                    taskStatus[taskIndex] = false;
                    System.out.println("____________________________________________________________");
                    System.out.println("OK, I've marked this task as not done yet:");
                    System.out.println("  [ ] " + tasks[taskIndex]);
                    System.out.println("____________________________________________________________");
                } else {
                    System.out.println("____________________________________________________________");
                    System.out.println("Invalid task number.");
                    System.out.println("____________________________________________________________");
                }
            } else {
                // Adding a new task to the list as long as it is under the max tasks limit
                if (taskCount < MAX_TASKS) {
                    tasks[taskCount] = userInput;
                    taskStatus[taskCount] = false; // Default: task is not done
                    taskCount++;
                    System.out.println("____________________________________________________________");
                    System.out.println("added: " + userInput);
                    System.out.println("____________________________________________________________");
                } else {
                    System.out.println("____________________________________________________________");
                    System.out.println("Task list is full. Cannot add more tasks.");
                    System.out.println("____________________________________________________________");
                }
            }
        }

        // Closing the Scanner
        scanner.close();
    }
}



