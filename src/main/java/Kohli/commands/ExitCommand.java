package Kohli.commands;

import Kohli.Storage;
import Kohli.TaskList;
import Kohli.Ui;

// Handles the "bye" command to exit the chatbot.
public class ExitCommand extends Command {

    // Executes the exit command by displaying bye message.
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showMessage("Bye. Hope to see you again soon!");
    }

    // Indicates that this command should terminate the chatbot.
    @Override
    public boolean isExit() {
        return true;
    }
}


