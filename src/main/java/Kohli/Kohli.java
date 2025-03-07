package Kohli;

import Kohli.commands.Command;

public class Kohli {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    // Initializes chatbot, setting up the UI, storage, and task list.
    public Kohli(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load()); // Load tasks from the file.
        } catch (KohliException e) {
            ui.showLoadingError(); // Show an error if loading fails.
            tasks = new TaskList(); // Start with an empty task list.
        }
    }

    // Runs the chatbot, processing user commands.
    public void run() {
        ui.showWelcome(); // Display welcome message.
        showPossibleErrors(); // Show possible user errors.

        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand(); // Read user input.
                ui.showLine();
                Command c = Parser.parse(fullCommand); // Parse input into appropriate command.
                c.execute(tasks, ui, storage); // Executes the command.
                isExit = c.isExit(); // Check if the command is an exit command.
            } catch (KohliException e) {
                ui.showError(e.getMessage()); // Handle invalid input.
            } finally {
                ui.showLine(); // Print a line for clarity.
            }
        }
    }

    // Displays common user input errors for guidance (user-friendly).
    private void showPossibleErrors() {
        ui.showLine();
<<<<<<< HEAD
<<<<<<< HEAD
        System.out.println("Possible Errors ");
=======
        System.out.println("  Possible Errors ");
>>>>>>> branch-Level-8
=======
        System.out.println(" Possible Errors ");
>>>>>>> branch-A-JavaDoc
        System.out.println(" Missing task description (e.g., 'todo' alone is invalid)");
        System.out.println(" Incorrect command format (e.g., missing /by for deadlines)");
        System.out.println(" Task number out of range for mark/unmark/delete");
        System.out.println(" Unrecognized command entered");
        ui.showLine();
    }

    // Entry point of the program. Initializes the chatbot with the file path.
    public static void main(String[] args) {
        new Kohli("C:\\Users\\Rishi Moorthy\\Desktop\\ip\\src\\main\\java\\Kohli\\data\\kohli.txt").run();
    }
}
