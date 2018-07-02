package com.NevernoteAPI.Note;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

//Spring MVC service layer that performs the logic and operations for the Note REST API calls
@Service
public class NoteService {
	
	private List<Note> notes = new ArrayList<>(Arrays.asList());
	
	// this method creates a Note and sets the created time stamp
	public void createNote(Note note) {
		notes.add(note);
		note.setCreatedTime(LocalDateTime.now().toString());
	}

	// this method retrieves all the notes specified for a notebook name
	public List<Note> retreiveAllNotes(String notebookName) {
		return notes;
	}

	// this method retrieves the Note contents for the specified Note title 
	public Note retreiveNote(String title) {
		return notes.stream().filter(n->n.getTitle().equals(title)).findFirst().get();
	}

	// this method updates the Note contents for a specified Note title
	// and sets the last modified time stamp
	public void updateNote(String title, Note note) {
		for(int i=0; i<notes.size();i++) {
			Note n = notes.get(i);
				if(n.getTitle().equals(title)) {			
					notes.set(i, note);
					note.setLastModifiedtime(LocalDateTime.now());	
					return;
				}
			}		
	}

	// this method deletes the specified Note
	public void deleteNote(String title) {
		notes.removeIf(n->n.getTitle().equals(title));
		
	}

}
