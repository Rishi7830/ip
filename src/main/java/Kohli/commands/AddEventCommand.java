package Kohli.commands;

import Kohli.*;
import Kohli.tasks.Event;
import Kohli.tasks.Task;

// Handles the "event" command to add a new Event task.
public class AddEventCommand extends Command {
    private final String description;
    private final String from;
    private final String to;

    /**
     * Constructs an AddEventCommand by parsing user input.
     * @param input The user input containing the task description, start time, and end time.
     * @throws KohliException If the input format is incorrect or the description is empty.
     */
    public AddEventCommand(String input) throws KohliException {
        String[] eventParts = input.split(" /from ", 2);

        // Ensures input contains both "from" and "to" segments.
        if (eventParts.length < 2 || !eventParts[1].contains(" /to ")) {
            throw new KohliException("Invalid format! Use: event <task> /from <start> /to <end>");
        }

        String[] timeParts = eventParts[1].split(" /to ", 2);
        this.description = eventParts[0];
        this.from = timeParts[0];
        this.to = timeParts[1];

        // Ensures the event has a valid description.
        if (description.trim().isEmpty()) {
            throw new KohliException("Oops! The description of an event cannot be empty.");
        }
    }

    /**
     * Executes the command to add a new Event task.
     * @param tasks   The task list where the event will be added.
     * @param ui      The user interface to display messages.
     * @param storage The storage handler to save the updated task list.
     * @throws KohliException If an error occurs while saving tasks.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws KohliException {
        Task newTask = new Event(description, from, to);
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


