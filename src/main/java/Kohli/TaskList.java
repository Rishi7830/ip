package Kohli;

import Kohli.tasks.Task;
import java.util.ArrayList;

// Manages the list of tasks, like adding, deleting, retrieving, and saving tasks.
public class TaskList {
    private ArrayList<Task> tasks;

    // Constructs an empty task list.
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    // Constructs an initialized task list with existing tasks.
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Adds a new task to the task list.
     * @param task The task to be added.
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Deletes a task from the list by its index.
     * @param index The index of the task to be removed.
     * @throws KohliException If the index is invalid, an error occurs.
     */
    public void deleteTask(int index) throws KohliException {
        if (index < 0 || index >= tasks.size()) {
            throw new KohliException("Invalid task number.");
        }
        tasks.remove(index);
    }

    /**
     * Retrieves the list of tasks.
     * @return The current list of tasks.
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    /**
     * Saves the task list to storage.
     * @param storage The storage handler for saving the tasks.
     * @throws KohliException If an error occurs.
     */
    public void save(Storage storage) throws KohliException {
        storage.save(tasks);
    }

    /**
     * Fix: Properly prints tasks using toString()
     */
    public void printTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Your to-do list is empty!");
        } else {
            System.out.println("Here are the tasks in your to-do list:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i).toString()); // Ensures toString() is used
            }
        }
    }
}

