package Kohli;

import Kohli.commands.Command;

public class Kohli {
    private final Storage storage; // Marked as final
    private final Ui ui; // Marked as final
    private TaskList tasks;

    // Initializes chatbot, setting up the UI, storage, and task list.
    public Kohli(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load()); // Load tasks from the file.
        } catch (KohliException e) {
            ui.showLoadingError(); // Show an error if loading fails.
            tasks = new TaskList();
        }
    }

    // Runs the chatbot, processing user commands.
    public void run() {
        ui.showWelcome();
        showPossibleErrors();

        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine();
                Command c = Parser.parse(fullCommand); // Parse input into appropriate command.
                c.execute(tasks, ui, storage); // Executes the command.
                isExit = c.isExit(); // Check if the command is an exit command.
            } catch (KohliException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

    // Displays common user input errors for guidance (user-friendly).
    private void showPossibleErrors() {
        ui.showLine();
        System.out.println("Possible Errors ");
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

