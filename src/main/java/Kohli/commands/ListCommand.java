package Kohli.commands;

import Kohli.Storage;
import Kohli.TaskList;
import Kohli.Ui;
import Kohli.tasks.Task;

public class ListCommand extends Command {
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

