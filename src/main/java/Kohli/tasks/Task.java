package Kohli.tasks;

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
        return (this instanceof Todo ? "T" : this instanceof Deadline ? "D" : "E") + " | " + (isDone ? "1" : "0") + " | " + description +
                (this instanceof Deadline ? " | " + ((Deadline) this).by : "") +
                (this instanceof Event ? " | " + ((Event) this).from + " | " + ((Event) this).to : "");
    }

    public static Task fromFileString(String line) {
        String[] parts = line.split(" \\| ");
        if (parts.length < 3) return null;

        String type = parts[0];
        boolean isDone = parts[1].equals("1");
        String description = parts[2];
        Task task;

        switch (type) {
            case "T":
                task = new Todo(description);
                break;
            case "D":
                if (parts.length < 4) return null;
                task = new Deadline(description, parts[3]);
                break;
            case "E":
                if (parts.length < 5) return null;
                task = new Event(description, parts[3], parts[4]);
                break;
            default:
                return null;
        }

        if (isDone) task.markAsDone();
        return task;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }
}
