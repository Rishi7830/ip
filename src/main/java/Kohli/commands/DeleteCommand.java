package Kohli.commands;

import Kohli.KohliException;
import Kohli.Storage;
import Kohli.TaskList;
import Kohli.Ui;
import Kohli.tasks.Task;

public class DeleteCommand extends Command {
    private int taskIndex;

    public DeleteCommand(String taskIndex) throws KohliException {
        try {
            this.taskIndex = Integer.parseInt(taskIndex) - 1;
        } catch (NumberFormatException e) {
            throw new KohliException("Invalid task number format.");
        }
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws KohliException {
        if (taskIndex < 0 || taskIndex >= tasks.getTasks().size()) {
            throw new KohliException("Task number out of range.");
        }

        Task removedTask = tasks.getTasks().remove(taskIndex);
        ui.showLine();
        System.out.println("Noted. I've removed this task:");
        System.out.println("  " + removedTask);
        System.out.println("Now you have " + tasks.getTasks().size() + " tasks in the list.");
        ui.showLine();

        tasks.save(storage);
    }
}

