package Kohli;

import Kohli.tasks.Task;
import java.io.*;
import java.util.ArrayList;

// Handles loading and saving of tasks to file.
public class Storage {
    private final String filePath; // Marked as final since it is never reassigned.

    // Constructs a Storage with the file path.
    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Loads tasks from the storage file and returns them as a list.
     * @return A list of tasks loaded from the file.
     * @throws KohliException If an error occurs while reading the file.
     */
    public ArrayList<Task> load() throws KohliException {
        ArrayList<Task> tasks = new ArrayList<>();
        File file = new File(filePath);

        // Ensure the parent directories exist before reading the file.
        if (!file.exists()) {
            if (!file.getParentFile().mkdirs()) {
                throw new KohliException("Failed to create directories for storage file.");
            }
        }

        // Reads the file line by line and converts each line into a Task object.
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                Task task = Task.fromFileString(line);
                if (task != null) {
                    tasks.add(task);
                }
            }
        } catch (IOException e) {
            throw new KohliException("Error reading file.");
        }
        return tasks;
    }

    /**
     * Saves the given list of tasks to the storage file.
     * @param tasks The list of tasks to be saved.
     * @throws KohliException If an error occurs while saving.
     */
    public void save(ArrayList<Task> tasks) throws KohliException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Task task : tasks) {
                bw.write(task.toFileString());
                bw.newLine();
            }
        } catch (IOException e) {
            throw new KohliException("Error saving file.");
        }
    }
}



