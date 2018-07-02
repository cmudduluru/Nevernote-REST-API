package com.NevernoteAPI.Notebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

// Spring MVC service layer that performs the logic and operations for the Notebook REST API Calls
@Service
public class NotebookService {
	
	private List<Notebook> notebooks = new ArrayList<>(Arrays.asList());

	// this method sends the welcome note to the base URI
	public String welcomeNote() {
		return "Hello, this is NeverNote REST API";
	}
	
	// this method creates a Notebook
	public void createNotebook(Notebook notebook) {
		notebooks.add(notebook);	
	}

	// this method returns the Notebook contents for the specified Notebook name 
	public Notebook retreiveNotebook(String name) {

		return notebooks.stream().filter(n->n.getName().equals(name)).findFirst().get();
	}

	// this method returns all the notebooks
	public List<Notebook> retreiveAllNotebooks() {
		return notebooks;
	}

	// this method deletes the specified Notebook
	public void deleteNotebook(String name) {
		notebooks.removeIf(n->n.getName().equals(name));
	}

}
