package com.taskmanager.model;

import java.util.Objects;

public class Task {
	
	private String title;
	private boolean completed;
	
	public Task() {
		// TODO Auto-generated constructor stub
	}
	
	public Task(String title) {
		super();
		this.title = title;
		this.completed = false;
	}

	public Task(String title, boolean isDone) {
		// TODO Auto-generated constructor stub
		this.title = title;
		this.completed = isDone;
	}

	public String getTitle() {
		return title;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void complete()
	{
		completed=true;
	}

	@Override
	public String toString() {
		String status=completed?"[✓]":"[ ]";
		return status+" "+title;
	}

	@Override
	public int hashCode() {
		return Objects.hash(completed, title);
	}

	@Override
	public boolean equals(Object obj) {
		if(this==obj)return true;
		if(!(obj instanceof Task other))return false;
		return this.title.equalsIgnoreCase(other.title);
	}
	
	
	
	
	
	

}
