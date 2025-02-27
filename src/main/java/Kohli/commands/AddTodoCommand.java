package Kohli.commands;

import Kohli.*;
import Kohli.tasks.Task;
import Kohli.tasks.Todo;

public class AddTodoCommand extends Command {
    private String description;

    public AddTodoCommand(String description) throws KohliException {
        if (description == null || description.trim().isEmpty()) {
            throw new KohliException("Oops! The description of a todo cannot be empty.");
        }
        this.description = description;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws KohliException {
        Task newTask = new Todo(description);
        tasks.addTask(newTask);

        ui.showLine();
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + newTask);
        System.out.println("Now you have " + tasks.getTasks().size() + " tasks in the list.");
        ui.showLine();

        tasks.save(storage);
    }
}

