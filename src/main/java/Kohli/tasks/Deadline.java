package Kohli.tasks;

import Kohli.util.DateTimeParser;
import java.time.LocalDateTime;

public class Deadline extends Task {
    protected LocalDateTime by;

    // Constructs a Deadline with description and date.
    public Deadline(String description, String by) {
        super(description);
        this.by = DateTimeParser.parse(by);
    }

    public Deadline(String description, LocalDateTime by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toString() {
<<<<<<< HEAD
        return "[D]" + super.toString() + " (by: " + DateTimeParser.format(by) + ")";
    }

    @Override
    public String toFileString() {
        return "D | " + (isDone ? "1" : "0") + " | " + description + " | " + DateTimeParser.formatForFile(by);
    }
}


=======
        // Returns the string representation of Deadline with its type [D].
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}

>>>>>>> branch-A-JavaDoc
