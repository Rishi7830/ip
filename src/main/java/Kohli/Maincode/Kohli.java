package Kohli.Maincode;

import java.util.Scanner;

public class Kohli {
    private static final int MAX_TASKS = 100;
    private static Task[] tasks = new Task[MAX_TASKS];
    private static int taskCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ASCII Logo
        String logo = "  _  ___   ____  _      ___ \n"
                +     " | |/ (_) |  _ \\| |    |_ _|\n"
                +     " | ' / _  | | | | |     | | \n"
                +     " | . \\| | | |_| | |___  | | \n"
                +     " |_|\\_\\_| |____/|_____| |___|\n";

        // ASCII Man
        String man =  "  O  \n"
                +    " /|\\ \n"
                +    " / \\ \n";

        System.out.println(logo);
        System.out.println(man);
        System.out.println("____________________________________________________________");
        System.out.println("Hello! I'm Kohli.");
        System.out.println("What can I do for you?");
        System.out.println("____________________________________________________________");

        // Display Menu of Commands
        System.out.println("\n✨ Available Commands ✨");
        System.out.println("1️⃣  todo <task>                - Adds a To-Do task");
        System.out.println("2️⃣  deadline <task> /by <time> - Adds a Deadline task");
        System.out.println("3️⃣  event <task> /from <start> /to <end> - Adds an Event task");
        System.out.println("4️⃣  list                        - Shows all tasks");
        System.out.println("5️⃣  mark <task number>          - Marks a task as done");
        System.out.println("6️⃣  unmark <task number>        - Unmarks a task");
        System.out.println("7️⃣  bye                         - Exits the chatbot");
        System.out.println("____________________________________________________________");

        // Display Possible Errors
        System.out.println("\n⚠️  Possible Errors ⚠️");
        System.out.println("❌ Missing task description (e.g., 'todo' alone is invalid)");
        System.out.println("❌ Incorrect command format (e.g., missing /by for deadlines)");
        System.out.println("❌ Task number out of range for mark/unmark");
        System.out.println("❌ Unrecognized command entered");
        System.out.println("____________________________________________________________");

        while (true) {
            String userInput = scanner.nextLine();
            String[] inputParts = userInput.split(" ", 2);
            String command = inputParts[0];

            try {
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
                } else if (command.equalsIgnoreCase("mark")) {
                    if (inputParts.length < 2) throw new KohliException("Please provide a task number to mark.");
                    int index = Integer.parseInt(inputParts[1]) - 1;
                    if (index < 0 || index >= taskCount) throw new KohliException("Invalid task number.");
                    tasks[index].markAsDone();
                    System.out.println("____________________________________________________________");
                    System.out.println("Nice! Great job! I've marked this task as done:");
                    System.out.println("  " + tasks[index]);
                    System.out.println("____________________________________________________________");
                } else if (command.equalsIgnoreCase("unmark")) {
                    if (inputParts.length < 2) throw new KohliException("Please provide a task number to unmark.");
                    int index = Integer.parseInt(inputParts[1]) - 1;
                    if (index < 0 || index >= taskCount) throw new KohliException("Invalid task number.");
                    tasks[index].unmarkAsDone();
                    System.out.println("____________________________________________________________");
                    System.out.println("OK, I've marked this task as not done yet:");
                    System.out.println("  " + tasks[index]);
                    System.out.println("____________________________________________________________");
                } else if (command.equalsIgnoreCase("todo")) {
                    if (inputParts.length < 2 || inputParts[1].trim().isEmpty()) throw new KohliException("Oops! The description of a todo cannot be empty.");
                    addTask(new Todo(inputParts[1]));
                } else if (command.equalsIgnoreCase("deadline")) {
                    if (inputParts.length < 2 || inputParts[1].trim().isEmpty()) throw new KohliException("Oops! The description of a deadline cannot be empty.");
                    String[] deadlineParts = inputParts[1].split(" /by ", 2);
                    if (deadlineParts.length < 2) throw new KohliException("Invalid format! Use: deadline <task> /by <time>");
                    addTask(new Deadline(deadlineParts[0], deadlineParts[1]));
                } else if (command.equalsIgnoreCase("event")) {
                    if (inputParts.length < 2 || inputParts[1].trim().isEmpty()) throw new KohliException("Oops! The description of an event cannot be empty.");
                    String[] eventParts = inputParts[1].split(" /from ", 2);
                    if (eventParts.length < 2 || !eventParts[1].contains(" /to ")) throw new KohliException("Invalid format! Use: event <task> /from <start> /to <end>");
                    String[] timeParts = eventParts[1].split(" /to ", 2);
                    addTask(new Event(eventParts[0], timeParts[0], timeParts[1]));
                } else {
                    throw new KohliException("Sorry, I don't understand that command. Try 'todo', 'deadline', or 'event'.");
                }
            } catch (KohliException | NumberFormatException e) {
                System.out.println("____________________________________________________________");
                System.out.println(e.getMessage());
                System.out.println("____________________________________________________________");
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
            System.out.println("Oh no! Your task list is full! Complete some tasks first.");
            System.out.println("____________________________________________________________");
        }
    }
}
