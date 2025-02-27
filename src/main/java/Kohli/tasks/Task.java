package Kohli.tasks;

import Kohli.util.DateTimeParser;
import java.time.format.DateTimeParseException;

public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public void unmarkAsDone() {
        this.isDone = false;
    }

    public String toFileString() {
        if (this instanceof Todo) {
            return "T | " + (isDone ? "1" : "0") + " | " + description;
        } else if (this instanceof Deadline) {
            return "D | " + (isDone ? "1" : "0") + " | " + description + " | " + DateTimeParser.formatForFile(((Deadline) this).by);
        } else if (this instanceof Event) {
            return "E | " + (isDone ? "1" : "0") + " | " + description + " | " + DateTimeParser.formatForFile(((Event) this).from) + " | " + DateTimeParser.formatForFile(((Event) this).to);
        }
        return ""; // Should never happen
    }

    public static Task fromFileString(String line) {
        String[] parts = line.split(" \\| ");
        if (parts.length < 3) return null;

        String type = parts[0];
        boolean isDone = parts[1].equals("1");
        String description = parts[2];
        Task task;

        try {
            switch (type) {
                case "T":
                    task = new Todo(description); // ✅ Todo tasks don't have dates
                    break;
                case "D":
                    if (parts.length < 4) {
                        System.out.println("Warning: Invalid Deadline format in file. Skipping entry.");
                        return null;
                    }
                    task = new Deadline(description, DateTimeParser.parseFromFile(parts[3]));
                    break;
                case "E":
                    if (parts.length < 5) {
                        System.out.println("Warning: Invalid Event format in file. Skipping entry.");
                        return null;
                    }
                    task = new Event(description, DateTimeParser.parseFromFile(parts[3]), DateTimeParser.parseFromFile(parts[4]));
                    break;
                default:
                    System.out.println("Warning: Unknown task type found in file. Skipping entry.");
                    return null;
            }
        } catch (DateTimeParseException e) {
            System.out.println("Warning: Invalid date format in file. Skipping entry.");
            return null;
        }

        if (isDone) task.markAsDone();
        return task;
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }
}
