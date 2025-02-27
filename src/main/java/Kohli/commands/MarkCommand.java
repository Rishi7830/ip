package Kohli.commands;

import Kohli.KohliException;
import Kohli.Storage;
import Kohli.TaskList;
import Kohli.Ui;
import Kohli.tasks.Task;

public class MarkCommand extends Command {
    private int taskIndex;

    public MarkCommand(String taskIndex) throws KohliException {
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

        Task task = tasks.getTasks().get(taskIndex);
        task.markAsDone();
        ui.showLine();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("  " + task);
        ui.showLine();

        tasks.save(storage);
    }
}

