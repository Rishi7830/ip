package Kohli.commands;

import Kohli.*;
import Kohli.tasks.Event;
import Kohli.tasks.Task;

public class AddEventCommand extends Command {
    private String description;
    private String from;
    private String to;

    public AddEventCommand(String input) throws KohliException {
        String[] eventParts = input.split(" /from ", 2);
        if (eventParts.length < 2 || !eventParts[1].contains(" /to ")) {
            throw new KohliException("Invalid format! Use: event <task> /from <start> /to <end>");
        }

        String[] timeParts = eventParts[1].split(" /to ", 2);
        this.description = eventParts[0];
        this.from = timeParts[0];
        this.to = timeParts[1];

        if (description.trim().isEmpty()) {
            throw new KohliException("Oops! The description of an event cannot be empty.");
        }
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws KohliException {
        Task newTask = new Event(description, from, to);
        tasks.addTask(newTask);

        ui.showLine();
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + newTask);
        System.out.println("Now you have " + tasks.getTasks().size() + " tasks in the list.");
        ui.showLine();

        tasks.save(storage);
    }
}

