package Kohli.commands;

import Kohli.KohliException;
import Kohli.Storage;
import Kohli.TaskList;
import Kohli.Ui;

// Represents an abstract command that can be executed in the chatbot.
public abstract class Command {
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws KohliException;
    public boolean isExit() {
        return false;
    }
}



