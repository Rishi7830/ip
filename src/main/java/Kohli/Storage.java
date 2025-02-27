package Kohli;

import Kohli.tasks.Task;

import java.io.*;
import java.util.ArrayList;

public class Storage {
    private String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<Task> load() throws KohliException {
        ArrayList<Task> tasks = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
        }

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

