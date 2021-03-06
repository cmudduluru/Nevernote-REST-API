package com.NevernoteAPI.Notebook;

// Spring MVC Model layer for Notebook class
public class Notebook {
	
	// fields
	private String name;
	private String description;
	
	public Notebook(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	public Notebook() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
