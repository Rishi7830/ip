package Kohli.commands;

import Kohli.*;
import Kohli.tasks.Deadline;
import Kohli.tasks.Task;

// Handles the "deadline" command to add a new Deadline task.
public class AddDeadlineCommand extends Command {
    private String description;
    private String by;

    /**
     * Constructs an AddDeadlineCommand by parsing user input.
     * @param input The user input containing the task description and deadline.
     * @throws KohliException If the input format is incorrect.
     */
    public AddDeadlineCommand(String input) throws KohliException {
        String[] parts = input.split(" /by ", 2);

        if (parts.length < 2) {
            throw new KohliException("Invalid format! Use: deadline <task> /by <time>");
        }
        this.description = parts[0];
        this.by = parts[1];

        if (description.trim().isEmpty()) {
            throw new KohliException("Oops! The description of a deadline cannot be empty.");
        }
    }

    /**
     * Executes the command to add a new Deadline task.
     * @param tasks   The task list where the deadline will be added.
     * @param ui      The user interface to display messages.
     * @param storage The storage handler to save the updated task list.
     * @throws KohliException If an error occurs while saving tasks.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws KohliException {
        Task newTask = new Deadline(description, by);
        tasks.addTask(newTask);

        // Display message for confirmation.
        ui.showLine();
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + newTask);
        System.out.println("Now you have " + tasks.getTasks().size() + " tasks in the list.");
        ui.showLine();

        tasks.save(storage);
    }
}


