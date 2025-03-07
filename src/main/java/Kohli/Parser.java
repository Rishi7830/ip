package Kohli;

import Kohli.commands.*;

// Handles parsing of user input and converts it into executable commands.
public class Parser {
    public static Command parse(String userInput) throws KohliException {
        String[] inputParts = userInput.split(" ", 2);
        String command = inputParts[0];

        // Matches the user command to the corresponding Command class.
        switch (command) {
            case "bye":
                return new ExitCommand();
            case "list":
                return new ListCommand();
            case "mark":
                return new MarkCommand(inputParts[1]);
            case "unmark":
                return new UnmarkCommand(inputParts[1]);
            case "delete":
                return new DeleteCommand(inputParts[1]);
            case "todo":
                return new AddTodoCommand(inputParts[1]);
            case "deadline":
                return new AddDeadlineCommand(inputParts[1]);
            case "event":
                return new AddEventCommand(inputParts[1]);
            default:
                throw new KohliException("Invalid command.");
        }
    }
}
