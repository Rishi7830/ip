package Kohli;

import java.util.Scanner;

public class Kohli {
    private static final int MAX_TASKS = 100;
    private static Task[] tasks = new Task[MAX_TASKS];
    private static int taskCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String logo = "  _  ___   ____  _      ___ \n"
                +     " | |/ (_) |  _ \\| |    |_ _|\n"
                +     " | ' / _  | | | | |     | | \n"
                +     " | . \\| | | |_| | |___  | | \n"
                +     " |_|\\_\\_| |____/|_____| |___|\n";

        String man =  "  O  \n"
                +    " /|\\ \n"
                +    " / \\ \n";

        System.out.println(logo);
        System.out.println(man);
        System.out.println("____________________________________________________________");
        System.out.println("Hello! I'm Kohli.\nWhat can I do for you?");
        System.out.println("____________________________________________________________");

        while (true) {
            String userInput = scanner.nextLine();
            String[] inputParts = userInput.split(" ", 2);
            String command = inputParts[0];

            if (command.equalsIgnoreCase("bye")) {
                System.out.println("____________________________________________________________");
                System.out.println("Bye. Hope to see you again soon! Let's complete more tasks together :)");
                System.out.println("____________________________________________________________");
                break;
            } else if (command.equalsIgnoreCase("list")) {
                System.out.println("____________________________________________________________");
                System.out.println("Here are the tasks in your to-do list:");
                for (int i = 0; i < taskCount; i++) {
                    System.out.println((i + 1) + ". " + tasks[i]);
                }
                System.out.println("____________________________________________________________");
            } else if (command.equalsIgnoreCase("mark") && inputParts.length > 1) {
                int index = Integer.parseInt(inputParts[1]) - 1;
                if (index >= 0 && index < taskCount) {
                    tasks[index].markAsDone();
                    System.out.println("____________________________________________________________");
                    System.out.println("Nice! Great Job! I've marked this task as done:");
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
            } else if (command.equalsIgnoreCase("todo") && inputParts.length > 1) {
                addTask(new Todo(inputParts[1]));
            } else if (command.equalsIgnoreCase("deadline") && inputParts.length > 1) {
                String[] deadlineParts = inputParts[1].split(" /by ", 2);
                if (deadlineParts.length > 1) {
                    addTask(new Deadline(deadlineParts[0], deadlineParts[1]));
                } else {
                    System.out.println("Invalid format! Use: deadline <task> /by <time>");
                }
            } else if (command.equalsIgnoreCase("event") && inputParts.length > 1) {
                String[] eventParts = inputParts[1].split(" /from ", 2);
                if (eventParts.length > 1) {
                    String[] timeParts = eventParts[1].split(" /to ", 2);
                    if (timeParts.length > 1) {
                        addTask(new Event(eventParts[0], timeParts[0], timeParts[1]));
                    } else {
                        System.out.println("Invalid format! Use: event <task> /from <start> /to <end>");
                    }
                } else {
                    System.out.println("Invalid format! Use: event <task> /from <start> /to <end>");
                }
            } else {
                System.out.println("Unknown command. Try 'todo', 'deadline', or 'event'.");
            }
        }

        scanner.close();
    }

    private static void addTask(Task task) {
        if (taskCount < MAX_TASKS) {
            tasks[taskCount] = task;
            taskCount++;
            System.out.println("____________________________________________________________");
            System.out.println("Got it. I've added this task:");
            System.out.println("  " + task);
            System.out.println("Now you have " + taskCount + " tasks in the list.");
            System.out.println("____________________________________________________________");
        } else {
            System.out.println("____________________________________________________________");
            System.out.println("Oh no! Your Kohli.Task list is full! Complete some tasks first.");
            System.out.println("____________________________________________________________");
        }
    }
}

