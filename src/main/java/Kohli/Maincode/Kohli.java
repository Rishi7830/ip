package Kohli.Maincode;

import java.util.ArrayList;
import java.util.Scanner;

public class Kohli {
    private static ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        tasks = Storage.loadTasksFromFile();

        // ASCII Logo
        String logo = "  _  ___   ____  _      ___ \n"
                + " | |/ (_) |  _ \\| |    |_ _|\n"
                + " | ' / _  | | | | |     | | \n"
                + " | . \\| | | |_| | |___  | | \n"
                + " |_|\\_\\_| |____/|_____| |___|\n";

        // ASCII Man
        String man = "  O  \n"
                + " /|\\ \n"
                + " / \\ \n";

        System.out.println(logo);
        System.out.println(man);
        System.out.println("____________________________________________________________");
        System.out.println("Hello! I'm Kohli.");
        System.out.println("What can I do for you?");
        System.out.println("____________________________________________________________");

        // Display Menu of Commands
        System.out.println("Here are the Available Commands Kohli bot can do for you :)");
        System.out.println("1️.  todo <task>                - Adds a To-Do task");
        System.out.println("2️.  deadline <task> /by <time> - Adds a Deadline task");
        System.out.println("3️.  event <task> /from <start> /to <end> - Adds an Event task");
        System.out.println("4️.  list                        - Shows all tasks");
        System.out.println("5️.  mark <task number>          - Marks a task as done");
        System.out.println("6️.  unmark <task number>        - Unmarks a task");
        System.out.println("7️.  delete <task number>        - Deletes a task");
        System.out.println("8️.  bye                         - Exits the chatbot");
        System.out.println("____________________________________________________________");

        // Display Possible Errors
        System.out.println("⚠️  Possible Errors ⚠️");
        System.out.println("❌ Missing task description (e.g., 'todo' alone is invalid)");
        System.out.println("❌ Incorrect command format (e.g., missing /by for deadlines)");
        System.out.println("❌ Task number out of range for mark/unmark/delete");
        System.out.println("❌ Unrecognized command entered");
        System.out.println("____________________________________________________________");

        while (true) {
            String userInput = scanner.nextLine();
            String[] inputParts = userInput.split(" ", 2);
            String command = inputParts[0];

            try {
                if (command.equalsIgnoreCase("bye")) {
                    System.out.println("____________________________________________________________");
                    System.out.println("Bye. Hope to see you again soon!");
                    System.out.println("____________________________________________________________");
                    break;
                } else if (command.equalsIgnoreCase("list")) {
                    System.out.println("____________________________________________________________");
                    System.out.println("Here are the tasks in your to-do list:");
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + ". " + tasks.get(i));
                    }
                    System.out.println("____________________________________________________________");
                } else if (command.equalsIgnoreCase("mark")) {
                    int index = Integer.parseInt(inputParts[1]) - 1;
                    tasks.get(index).markAsDone();
                    Storage.saveTasksToFile(tasks);
                    System.out.println("____________________________________________________________");
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println("  " + tasks.get(index));
                    System.out.println("____________________________________________________________");
                } else if (command.equalsIgnoreCase("unmark")) {
                    int index = Integer.parseInt(inputParts[1]) - 1;
                    tasks.get(index).unmarkAsDone();
                    Storage.saveTasksToFile(tasks);
                    System.out.println("____________________________________________________________");
                    System.out.println("OK, I've marked this task as not done yet:");
                    System.out.println("  " + tasks.get(index));
                    System.out.println("____________________________________________________________");
                } else if (command.equalsIgnoreCase("todo")) {
                    addTask(new Todo(inputParts[1]));
                } else if (command.equalsIgnoreCase("deadline")) {
                    String[] deadlineParts = inputParts[1].split(" /by ", 2);
                    addTask(new Deadline(deadlineParts[0], deadlineParts[1]));
                } else if (command.equalsIgnoreCase("event")) {
                    String[] eventParts = inputParts[1].split(" /from ", 2);
                    String[] timeParts = eventParts[1].split(" /to ", 2);
                    addTask(new Event(eventParts[0], timeParts[0], timeParts[1]));
                } else if (command.equalsIgnoreCase("delete")) {
                    DeleteTask.removeTask(tasks, Integer.parseInt(inputParts[1]) - 1);
                    Storage.saveTasksToFile(tasks);
                } else {
                    throw new KohliException("Sorry, I don't understand that command.");
                }
            } catch (Exception e) {
                System.out.println("____________________________________________________________");
                System.out.println(e.getMessage());
                System.out.println("____________________________________________________________");
            }
        }
        scanner.close();
    }

    private static void addTask(Task task) {
        tasks.add(task);
        Storage.saveTasksToFile(tasks);
        System.out.println("____________________________________________________________");
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + task);
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
        System.out.println("____________________________________________________________");
    }
}

