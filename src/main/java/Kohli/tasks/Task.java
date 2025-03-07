package Kohli.tasks;

public class Task {
    protected String description;
    protected boolean isDone;

    // Constructs a new task with the given description. By default, the task is not marked as done.
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    // Returns "X" if done, " " if not done.
    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    // Marks the task as done.
    public void markAsDone() {
        this.isDone = true;
    }

    // Unmarks the task, setting it back to incomplete task.
    public void unmarkAsDone() {
        this.isDone = false;
    }

    // Converts the task into a formatted string suitable for file storage so the user can save it in text file.
    public String toFileString() {
        return (this instanceof Todo ? "T" : this instanceof Deadline ? "D" : "E") + " | "
                + (isDone ? "1" : "0") + " | " + description
                + (this instanceof Deadline ? " | " + ((Deadline) this).by : "")
                + (this instanceof Event ? " | " + ((Event) this).from + " | " + ((Event) this).to : "");
    }

    // Parses a task from a formatted string from the saved file.
    public static Task fromFileString(String line) {
        String[] parts = line.split(" \\| ");
        if (parts.length < 3) return null;
        String type = parts[0];
        boolean isDone = parts[1].equals("1");
        String description = parts[2];
        Task task;

        // Creates the appropriate task type based on the first character in the file.
        switch (type) {
            case "T":
                task = new Todo(description);
                break;
            case "D":
                if (parts.length < 4) return null; // Ensures deadlines have valid dates.
                task = new Deadline(description, parts[3]);
                break;
            case "E":
                if (parts.length < 5) return null; // Ensures events have start and end dates.
                task = new Event(description, parts[3], parts[4]);
                break;
            default:
                return null; // Returns null if it's an unknown task type.
        }

        if (isDone) task.markAsDone(); // Restores the task's completion status.
        return task;
    }

    @Override
    public String toString() {
        // Returns a string representation of the task.
        return "[" + getStatusIcon() + "] " + description;
    }
}

