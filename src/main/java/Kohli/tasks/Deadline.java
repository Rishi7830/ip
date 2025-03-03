package Kohli.tasks;

public class Deadline extends Task {
    protected String by;

    // Constructs a Deadline with description and date.
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toString() {
        // Returns the string representation of Deadline with its type [D].
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}

