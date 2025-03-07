package Kohli;

import Kohli.tasks.Task;
import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void deleteTask(int index) throws KohliException {
        if (index < 0 || index >= tasks.size()) {
            throw new KohliException("Invalid task number.");
        }
        tasks.remove(index);
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void save(Storage storage) throws KohliException {
        storage.save(tasks);
    }

<<<<<<< HEAD
    public ArrayList<Task> findTasks(String keyword) {
        ArrayList<Task> matchingTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getDescription().toLowerCase().contains(keyword)) {
                matchingTasks.add(task);
            }
        }
        return matchingTasks;
=======
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
>>>>>>> branch-Level-8
    }
}

