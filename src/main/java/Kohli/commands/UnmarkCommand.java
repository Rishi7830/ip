package Kohli.commands;

import Kohli.KohliException;
import Kohli.Storage;
import Kohli.TaskList;
import Kohli.Ui;
import Kohli.tasks.Task;

// Handles the "unmark" command to mark a task as not completed.
public class UnmarkCommand extends Command {
    private int taskIndex;

    /**
     * Constructs an UnmarkCommand by parsing the task index from user input.
     * @param taskIndex The task number to be unmarked.
     * @throws KohliException If the task number is not a valid integer.
     */
    public UnmarkCommand(String taskIndex) throws KohliException {
        try {
            this.taskIndex = Integer.parseInt(taskIndex) - 1;
        } catch (NumberFormatException e) {
            throw new KohliException("Invalid task number format.");
        }
    }

    /**
     * Executes the unmark command, marking the specified task as incomplete.
     * @param tasks   The task list where the task will be unmarked.
     * @param ui      The user interface to display messages.
     * @param storage The storage handler to save the updated task list.
     * @throws KohliException If the task index is out of range.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws KohliException {
        // Ensure the task index is within a valid range.
        if (taskIndex < 0 || taskIndex >= tasks.getTasks().size()) {
            throw new KohliException("Task number out of range.");
        }

        // Gets the task from the list and mark it as not done.
        Task task = tasks.getTasks().get(taskIndex);
        task.unmarkAsDone();

        // Display message confirmation.
        ui.showLine();
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println("  " + task);
        ui.showLine();

        tasks.save(storage);
    }
}


