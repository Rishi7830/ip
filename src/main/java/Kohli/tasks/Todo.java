package Kohli.tasks;

public class Todo extends Task {

    // Constructor for todo task which requires only description.
    public Todo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        // Returns the string todo task with its type [T].
        return "[T]" + super.toString();
    }
}


