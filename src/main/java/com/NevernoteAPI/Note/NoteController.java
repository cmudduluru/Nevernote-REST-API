package com.NevernoteAPI.Note;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//This Spring MVC - Controller layer exposes the Note REST methods and 
//maps the URI to the methods that perform the CRUD operations
@RestController
public class NoteController {
	
	// Injecting the dependency here
	@Autowired
	private NoteService noteService;
	
	// this method calls the noteService createNote method to create 
	// a note using the contents provided for the specified Notebook
	@RequestMapping(method = RequestMethod.POST, value="/notebooks/{notebookName}/notes")
	public void createNote(@RequestBody Note note, @PathVariable String notebookName) {
		noteService.createNote(note);
	}
	
	// this method calls the noteService retreiveAllNotes method to 
	// retrieve all the available Notes for the specified Notebook name
	@RequestMapping(method = RequestMethod.GET, value = "/notebooks/{notebookName}/notes")
	public List<Note> retreiveAllNotes(@PathVariable String notebookName){
		return noteService.retreiveAllNotes(notebookName);		
	}
	
	// this method calls the noteService retreiveNote method to 
	// retrieve Note contents for the specified Note title 
	@RequestMapping(method = RequestMethod.GET, value = "/notebooks/{notebookName}/notes/{title}")
	public Note retreiveNote(@PathVariable String title) {
		return noteService.retreiveNote(title);
	}
	
	// this method calls the noteService updateNote method to update 
	// a specified note using the contents provided
	@RequestMapping(method = RequestMethod.PUT, value = "/notebooks/{notebookName}/notes/{title}")
	public void updateNote(@RequestBody Note note, @PathVariable String notebookName ,@PathVariable String title) {
		noteService.updateNote(title, note);
	}

	// this method calls the noteService deleteNote method to 
	// delete a Note for the specified Note title
	@RequestMapping(method = RequestMethod.DELETE, value = "/notebooks/{notebookName}/notes/{title}")
	public void deleteNote(@PathVariable String title) {
		noteService.deleteNote(title);
	}

}
