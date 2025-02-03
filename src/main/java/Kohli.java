import java.util.Scanner;

public class Kohli {
    private static final int MAX_TASKS = 100;
    private static Task[] tasks = new Task[MAX_TASKS];
    private static int taskCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("____________________________________________________________");
        System.out.println("Hello! I'm Kohli\nWhat can I do for you?");
        System.out.println("____________________________________________________________");

        while (true) {
            String userInput = scanner.nextLine();
            String[] inputParts = userInput.split(" ", 2);
            String command = inputParts[0];

            if (command.equalsIgnoreCase("bye")) {
                System.out.println("____________________________________________________________");
                System.out.println("Bye. Hope to see you again soon!");
                System.out.println("____________________________________________________________");
                break;
            } else if (command.equalsIgnoreCase("list")) {
                System.out.println("____________________________________________________________");
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < taskCount; i++) {
                    System.out.println((i + 1) + ". " + tasks[i]);
                }
                System.out.println("____________________________________________________________");
            } else if (command.equalsIgnoreCase("mark") && inputParts.length > 1) {
                int index = Integer.parseInt(inputParts[1]) - 1;
                if (index >= 0 && index < taskCount) {
                    tasks[index].markAsDone();
                    System.out.println("____________________________________________________________");
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println("  " + tasks[index]);
                    System.out.println("____________________________________________________________");
                }
            } else if (command.equalsIgnoreCase("unmark") && inputParts.length > 1) {
                int index = Integer.parseInt(inputParts[1]) - 1;
                if (index >= 0 && index < taskCount) {
                    tasks[index].unmarkAsDone();
                    System.out.println("____________________________________________________________");
                    System.out.println("OK, I've marked this task as not done yet:");
                    System.out.println("  " + tasks[index]);
                    System.out.println("____________________________________________________________");
                }
            } else {
                if (taskCount < MAX_TASKS) {
                    tasks[taskCount] = new Task(userInput);
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

        scanner.close();
    }
}
