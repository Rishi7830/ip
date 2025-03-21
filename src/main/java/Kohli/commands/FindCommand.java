package Kohli.commands;

import Kohli.Storage;
import Kohli.TaskList;
import Kohli.Ui;
import Kohli.tasks.Task;
import java.util.ArrayList;

public class FindCommand extends Command {
    private final String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword.toLowerCase(); // Convert to lowercase for case-insensitive search
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ArrayList<Task> matchingTasks = tasks.findTasks(keyword);

        ui.showLine();
        if (matchingTasks.isEmpty()) {
            System.out.println("No matching tasks found.");
        } else {
            System.out.println("Here are the matching tasks in your list:");
            for (int i = 0; i < matchingTasks.size(); i++) {
                System.out.println((i + 1) + ". " + matchingTasks.get(i));
            }
        }
        ui.showLine();
    }
}

