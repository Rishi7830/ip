package Kohli.commands;

import Kohli.*;
import Kohli.tasks.Task;
import Kohli.tasks.Todo;

// Handles the "todo" command to add a new Todo task.
public class AddTodoCommand extends Command {
    private final String description;

    /**
     * Constructs an AddTodoCommand with the given task description.
     * @param description The description of the To-Do task.
     * @throws KohliException If the description is null or empty.
     */
    public AddTodoCommand(String description) throws KohliException {
        if (description == null || description.trim().isEmpty()) {
            throw new KohliException("Oops! The description of a todo cannot be empty.");
        }
        this.description = description;
    }

    /**
     * Executes the command to add a new To-Do task.
     * @param tasks   The task list where the To-Do will be added.
     * @param ui      The user interface to display messages.
     * @param storage The storage handler to save the updated task list.
     * @throws KohliException If an error occurs while saving tasks.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws KohliException {
        Task newTask = new Todo(description);
        tasks.addTask(newTask);

        // Display message confirmation.
        ui.showLine();
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + newTask);
        System.out.println("Now you have " + tasks.getTasks().size() + " tasks in the list.");
        ui.showLine();

        tasks.save(storage);
    }
}


