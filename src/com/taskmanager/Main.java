package com.taskmanager;

import java.util.Scanner;

import com.taskmanager.service.Filehandler;
import com.taskmanager.service.TaskManager;

public class Main {
	
	public static void main(String[] args) {

        TaskManager manager = new TaskManager();

        // Load existing tasks from file when app starts
        manager.setTasks(Filehandler.load());

        // Scanner reads from System.in = your keyboard
        Scanner scanner = new Scanner(System.in);

        printWelcome();

        // ── MAIN LOOP ─────────────────────────────────────────
        // do-while: always runs at least ONCE, then checks condition.
        // Perfect here — we always want to show the prompt at least once.
        boolean running = true;
        do {
            System.out.print("\n> Enter command: ");
            String input = scanner.nextLine().trim();

            // Switch statement on the COMMAND part of input
            // e.g. "add Buy milk" → command="add", argument="Buy milk"
            String command = extractCommand(input);
            String argument = extractArgument(input);

            switch (command) {
                case "add" -> {
                    manager.addTask(argument);
                    Filehandler.save(manager.getTasks());  // save after every change
                }
                case "list" -> manager.listTasks();

                case "complete", "done" -> {
                    int index = parseIndex(argument);
                    if (index > 0) {
                        manager.completeTask(index);
                        Filehandler.save(manager.getTasks());
                    }
                }
                case "delete", "remove" -> {
                    int index = parseIndex(argument);
                    if (index > 0) {
                        manager.deleteTask(index);
                        Filehandler.save(manager.getTasks());
                    }
                }
                case "help" -> printHelp();

                case "exit", "quit" -> {
                    System.out.println("👋 Goodbye! Your tasks are saved.");
                    running = false;
                }

                // default catches anything not matched above
                default -> System.out.println("❓ Unknown command. Type 'help' for options.");
            }

        } while (running);

        scanner.close();
    }

    // ── HELPERS ──────────────────────────────────────────────

    // "add Buy milk" → "add"
    // Variable Scope: these methods can only see what's passed to them
    private static String extractCommand(String input) {
        if (input == null || input.isEmpty()) return "";
        return input.split(" ")[0].toLowerCase();
    }

    // "add Buy milk" → "Buy milk"
    private static String extractArgument(String input) {
        int spaceIndex = input.indexOf(' ');
        // Ternary: if there's a space, return everything after it, else ""
        return spaceIndex >= 0 ? input.substring(spaceIndex + 1).trim() : "";
    }

    // Safely parse "3" → 3, or print error and return -1
    private static int parseIndex(String argument) {
        try {
            return Integer.parseInt(argument.trim());
        } catch (NumberFormatException e) {
            System.out.println("❌ Please provide a valid task number. Example: complete 2");
            return -1;
        }
    }

    private static void printWelcome() {
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║      CLI Task Manager 📝      ║");
        System.out.println("╚══════════════════════════════╝");
        System.out.println("Type 'help' to see commands.");
    }

    private static void printHelp() {
        System.out.println("""
                
                📖 Available Commands:
                ──────────────────────────────────
                  add <task>        Add a new task
                  list              Show all tasks
                  complete <num>    Mark task as done
                  delete <num>      Delete a task
                  help              Show this menu
                  exit              Quit the app
                ──────────────────────────────────
                Example: add Buy groceries
                         complete 1
                """);
    }

}
