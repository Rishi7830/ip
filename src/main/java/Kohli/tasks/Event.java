package Kohli.tasks;

import Kohli.util.DateTimeParser;
import java.time.LocalDateTime;

public class Event extends Task {
    protected LocalDateTime from;
    protected LocalDateTime to;

    // Constructs an Event with description, start time, and end time.
    public Event(String description, String from, String to) {
        super(description);
        this.from = DateTimeParser.parse(from);
        this.to = DateTimeParser.parse(to);
    }

    public Event(String description, LocalDateTime from, LocalDateTime to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
<<<<<<< HEAD
        return "[E]" + super.toString() + " (from: " + DateTimeParser.format(from) + " to: " + DateTimeParser.format(to) + ")";
    }

    @Override
    public String toFileString() {
        return "E | " + (isDone ? "1" : "0") + " | " + description + " | " + DateTimeParser.formatForFile(from) + " | " + DateTimeParser.formatForFile(to);
    }
}
=======
        // Returns the string representation of Event with its type [E].
        return "[E]" + super.toString() + " (from: " + from + " to: " + to + ")";
    }
}


>>>>>>> branch-A-JavaDoc
