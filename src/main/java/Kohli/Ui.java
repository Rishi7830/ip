package Kohli;

import java.util.Scanner;

// Handles user interactions like displaying messages and reading user input.
public class Ui {
    private Scanner scanner; // Scanner to read user input.

    // Initializes the UI and sets up the scanner to read commands.
    public Ui() {
        scanner = new Scanner(System.in);
    }

    // Displays the welcome message, logo, and commands menu.
    public void showWelcome() {
        String logo = "  _  ___   ____  _      ___ \n"
                + " | |/ (_) |  _ \\| |    |_ _|\n"
                + " | ' / _  | | | | |     | | \n"
                + " | . \\| | | |_| | |___  | | \n"
                + " |_|\\_\\_| |____/|_____| |___|\n";
        String man = "  O  \n"
                + " /|\\ \n"
                + " / \\ \n";

        System.out.println(logo);
        System.out.println(man);
        showLine();
        System.out.println("Hello! I'm Kohli.");
        System.out.println("What can I do for you?");
        showLine();
        showMenu();
    }

    // Displays the commands menu that the chatbot can execute.
    public void showMenu() {
        System.out.println("Here are the Available Commands Kohli bot can do for you :)");
        System.out.println("1. todo <task>                - Adds a To-Do task");
        System.out.println("2. deadline <task> /by <time> - Adds a Deadline task");
        System.out.println("3. event <task> /from <start> /to <end> - Adds an Event task");
        System.out.println("4. list                        - Shows all tasks");
        System.out.println("5. mark <task number>          - Marks a task as done");
        System.out.println("6. unmark <task number>        - Unmarks a task");
        System.out.println("7. delete <task number>        - Deletes a task");
        System.out.println("8. bye                         - Exits the chatbot");
        showLine();
    }

    // Prints a horizontal line.
    public void showLine() {
        System.out.println("____________________________________________________________");
    }

    // Reads and returns the next user command from the console.
    public String readCommand() {
        return scanner.nextLine();
    }

    // Displays an error message.
    public void showError(String message) {
        System.out.println("⚠ " + message);
    }

    // Displays an error message when the task loading fails.
    public void showLoadingError() {
        System.out.println("Error loading tasks. Starting with an empty task list.");
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}


