package Kohli.commands;

import Kohli.KohliException;
import Kohli.Storage;
import Kohli.TaskList;
import Kohli.Ui;
import Kohli.tasks.Task;

// Handles the "mark" command to mark a task as completed.
public class MarkCommand extends Command {
    private int taskIndex;

    /**
     * Constructs a MarkCommand by parsing the task index from user input.
     * @param taskIndex The task number to be marked as done.
     * @throws KohliException If the task number is not a valid integer.
     */
    public MarkCommand(String taskIndex) throws KohliException {
        try {
            this.taskIndex = Integer.parseInt(taskIndex) - 1;
        } catch (NumberFormatException e) {
            throw new KohliException("Invalid task number format.");
        }
    }

    /**
     * Executes the mark command, marking the specified task as completed.
     * @param tasks   The task list where the task will be marked.
     * @param ui      The user interface to display messages.
     * @param storage The storage handler to save the updated task list.
     * @throws KohliException If the task index is out of range.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws KohliException {
        // Ensure the task index is within valid range.
        if (taskIndex < 0 || taskIndex >= tasks.getTasks().size()) {
            throw new KohliException("Task number out of range.");
        }

        // Gets the task from the list and mark it as done.
        Task task = tasks.getTasks().get(taskIndex);
        task.markAsDone();

        // Display message confirmation.
        ui.showLine();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("  " + task);
        ui.showLine();

        tasks.save(storage);
    }
}

