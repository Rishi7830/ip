package Kohli.tasks;

public class Event extends Task {
    protected String from;
    protected String to;

    // Constructs an Event with description, start time, and end time.
    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        // Returns the string representation of Event with its type [E].
        return "[E]" + super.toString() + " (from: " + from + " to: " + to + ")";
    }
}


