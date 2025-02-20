package Kohli.Maincode;

import java.util.ArrayList;

public class DeleteTask {
    public static void removeTask(ArrayList<Task> tasks, int index) {
        if (index < 0 || index >= tasks.size()) {
            System.out.println("____________________________________________________________");
            System.out.println("Invalid task number. Please try again.");
            System.out.println("____________________________________________________________");
            return;
        }
        Task removedTask = tasks.remove(index);
        System.out.println("____________________________________________________________");
        System.out.println("Noted. I've removed this task:");
        System.out.println("  " + removedTask);
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
        System.out.println("____________________________________________________________");
    }
}

