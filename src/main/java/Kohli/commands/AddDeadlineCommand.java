package Kohli.commands;

import Kohli.*;
import Kohli.tasks.Deadline;
import Kohli.tasks.Task;

public class AddDeadlineCommand extends Command {
    private String description;
    private String by;

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

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws KohliException {
        Task newTask = new Deadline(description, by);
        tasks.addTask(newTask);

        ui.showLine();
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + newTask);
        System.out.println("Now you have " + tasks.getTasks().size() + " tasks in the list.");
        ui.showLine();

        tasks.save(storage);
    }
}

