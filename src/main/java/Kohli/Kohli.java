package Kohli;

import Kohli.commands.Command;

public class Kohli {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Kohli(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (KohliException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    public void run() {
        ui.showWelcome();
        showPossibleErrors(); // Show possible errors

        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (KohliException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

    private void showPossibleErrors() {
        ui.showLine();
        System.out.println("Possible Errors ");
        System.out.println(" Missing task description (e.g., 'todo' alone is invalid)");
        System.out.println(" Incorrect command format (e.g., missing /by for deadlines)");
        System.out.println(" Task number out of range for mark/unmark/delete");
        System.out.println(" Unrecognized command entered");
        ui.showLine();
    }

    public static void main(String[] args) {
        new Kohli("C:\\Users\\Rishi Moorthy\\Desktop\\ip\\src\\main\\java\\Kohli\\data\\kohli.txt").run();
    }
}
