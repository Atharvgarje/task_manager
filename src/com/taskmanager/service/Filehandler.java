package com.taskmanager.service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.taskmanager.model.Task;

public class Filehandler {

    private static final String FILE_PATH = "tasks.txt";

  
    public static void save(List<Task> tasks) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {

            for (Task task : tasks) {
               
                StringBuilder sb = new StringBuilder();
                sb.append(task.isCompleted() ? "DONE" : "TODO");
                sb.append("|");
                sb.append(task.getTitle());
                writer.write(sb.toString());
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println(" Error saving tasks: " + e.getMessage());
        }
    }

  
    public static List<Task> load() {
        List<Task> tasks = new ArrayList<>();
        File file = new File(FILE_PATH);

      
        if (!file.exists()) return tasks;

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;  

               
                String[] parts = line.split("\\|", 2);

                if (parts.length == 2) {
                    boolean isDone = parts[0].equals("DONE");
                    tasks.add(new Task(parts[1],isDone));
                    
                }
            }

        } catch (IOException e) {
            System.out.println(" Error loading tasks: " + e.getMessage());
        }

        return tasks;
    }
}