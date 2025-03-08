package Kohli.commands;

import Kohli.KohliException;
import Kohli.Storage;
import Kohli.TaskList;
import Kohli.Ui;
import Kohli.tasks.Task;

// Handles the "delete" command to remove a task from the task list.
public class DeleteCommand extends Command {
    private final int taskIndex;

    /**
     * Constructs a DeleteCommand by parsing the task index from user input.
     *
     * @param taskIndex The task number to be deleted.
     * @throws KohliException If the task number is not a valid integer.
     */
    public DeleteCommand(String taskIndex) throws KohliException {
        try {
            this.taskIndex = Integer.parseInt(taskIndex) - 1;
        } catch (NumberFormatException e) {
            throw new KohliException("Invalid task number format.");
        }
    }

    /**
     * Executes the delete command, removing the specified task from the list.
     *
     * @param tasks   The task list where the task will be removed.
     * @param ui      The user interface to display messages.
     * @param storage The storage handler to save the updated task list.
     * @throws KohliException If the task index is out of range.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws KohliException {
        if (taskIndex < 0 || taskIndex >= tasks.getTasks().size()) {
            throw new KohliException("Task number out of range.");
        }

        Task removedTask = tasks.getTasks().get(taskIndex); // Get the task before deleting
        tasks.deleteTask(taskIndex); // Use deleteTask() instead of direct removal

        ui.showLine();
        System.out.println("Noted. I've removed this task:");
        System.out.println("  " + removedTask);
        System.out.println("Now you have " + tasks.getTasks().size() + " tasks in the list.");
        ui.showLine();

        tasks.save(storage);
    }
}



