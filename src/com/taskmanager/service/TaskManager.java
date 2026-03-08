package com.taskmanager.service;

import java.util.ArrayList;
import java.util.List;

import com.taskmanager.model.Task;

public class TaskManager {
	
	List<Task> tasks=new ArrayList<Task>();
	
	public void addTask(String title)
	{
		if(title==null || title.isEmpty())
		{
			System.out.println("Please Enter the valid title");
		}
		tasks.add(new Task(title.trim()));
		System.out.println("Title added successfully ");
	}
	
	 public void listTasks() {
	        if (tasks.isEmpty()) {
	            System.out.println("📋 No tasks yet. Add one with: add <task name>");
	            return;
	        }

	        System.out.println("\n📋 Your Tasks:");
	        System.out.println("─".repeat(40));

	        for (int i = 0; i < tasks.size(); i++) {
	            System.out.printf("  %d. %s%n", i + 1, tasks.get(i));
	        }
	        System.out.println("─".repeat(40));

	        long doneCount = tasks.stream().filter(Task::isCompleted).count();
	        System.out.printf("  %d/%d tasks completed%n%n", doneCount, tasks.size());
	    }
	
	public List<Task> getTasks()
	{
		return tasks;
	}
	
	public void completeTask(int index) {
		// TODO Auto-generated method stub
		if(!(isvalidIndex(index)))
		{
			return;
		}
		Task task =tasks.get(index-1);
		if(task.isCompleted()) {
			System.out.println("Task already completed: "+task.getTitle());
			
		}
		else
		{
			task.complete();
			System.out.println("Completed: "+task.getTitle());
		}

	}
	
	public void deleteTask(int index) {
        if (!isvalidIndex(index)) return;

        Task removed = tasks.remove(index - 1);
        System.out.println("🗑️  Deleted: " + removed.getTitle());
    }
	
	public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
	
	private boolean isvalidIndex(int index)
	{
		if(tasks.isEmpty()) {
			System.out.println(" No tasks to act on.");
			return false;
		}
		if(index<1 && index>tasks.size())
		{
			System.out.println("Invalid taks number, choose between 1 and "+tasks.size());
			return false;
		}
		return true;
	}

}
