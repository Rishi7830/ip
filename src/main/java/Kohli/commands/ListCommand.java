package Kohli.commands;

import Kohli.Storage;
import Kohli.TaskList;
import Kohli.Ui;
import Kohli.tasks.Task;

// Handles the "list" command to display all tasks in the task list.
public class ListCommand extends Command {

    // Executes the list command by listing out all tasks with their index.
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showLine();
        System.out.println("Here are the tasks in your to-do list:");

        int index = 1;
        for (Task task : tasks.getTasks()) {
            System.out.println(index + ". " + task);
            index++;
        }

        ui.showLine();
    }
}


