package com.NevernoteAPI;

import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.when;
import static org.junit.Assert.assertNotSame;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType; 

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
//import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.NevernoteAPI.Note.Note;
import com.NevernoteAPI.Note.NoteController;
import com.NevernoteAPI.Note.NoteService;

//Unit tests for NoteController using JUnit, WebMvcTest, SpringBootTest, Mockito
@RunWith(SpringRunner.class)
@WebMvcTest(NoteController.class)
public class NoteControllerTest {

    LocalDateTime lastModified = null;
	String createdTime = LocalDateTime.now().toString();
    String[] TagsArray1 = {"Circle", "Square", "Rectangle"};
    String[] TagsArray2 = {"Scalar", "Vector"};
    String[] TagsArray3 = {"Formula1", "Formula2", "Formula3"};
	
    @Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private NoteService noteService;
	
	String exampleNoteJson1 = "{\"title\":\"Geometry\","
			+ "\"body\":\"This is Geometry notes\","
			+ "\"tags\":{\\\"Circle\\\",\\\"Square\\\",\\\"Rectangle\\\"},"
			+ "\"createdTime\":createdTime,"
			+ "lastModifiedtime\":lastModified}";
	
	String exampleNoteJson2 = "{\"title\":\"Calculus\","
			+ "\"body\":\"This is Calculus notes\","
			+ "\"tags\":{\\\"Scalar\\\",\\\"Vector\\\"},"
			+ "\"createdTime\":createdTime,"
			+ "lastModifiedtime\":lastModified}";

	String exampleNoteJson3 = "{\"title\":\"Algebra\","
			+ "\"body\":\"This is Algebra notes\","
			+ "\"tags\":{\\\"Formula1\\\",\\\"Formula2\\\",\\\"Formula3\\\"},"
			+ "\"createdTime\":createdTime,"
			+ "lastModifiedtime\":lastModified}";
	
	private List<Note> mockNotes = new ArrayList<>(Arrays.asList());
	Note mockNote1 = new Note("Geometry","This is Geometry notes",TagsArray1,"createdTime", lastModified);
	Note mockNote2 = new Note("Calculus","This is Calculus notes",TagsArray2,"createdTime", lastModified);
	Note mockNote3 = new Note("Algebra","This is Algebra notes",TagsArray3,"createdTime", lastModified);

	// Unit testing the createNote method 
	@Test
	public void createNote() throws Exception {
		//Mockito.doNothing().when(noteService).createNote(Mockito.any(Note.class));
		Mockito.doNothing().when(noteService).createNote(Mockito.any(Note.class));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/notebooks/notebookName/notes").accept(MediaType.APPLICATION_JSON)
				.content(exampleNoteJson1)
				.contentType(MediaType.APPLICATION_JSON);
		
	    MvcResult result = mockMvc.perform(requestBuilder).andReturn(); 
	    
		MockHttpServletResponse response = result.getResponse();
		
		assertNotSame(HttpStatus.OK.value(), response.getStatus());
		
	}
	
	// Unit testing the retreiveNote method 
	@Test
	public void retrieveSpecificNotesTest() throws Exception {
		Mockito.when(noteService.retreiveAllNotes(Mockito.anyString())).thenReturn(mockNotes);
	    Mockito.when(noteService.retreiveNote(Mockito.anyString())).thenReturn(mockNote1);
	RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
			"/notebooks/notebookName/notes/title").accept(
			MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	   // Unit testing the retreiveAllNotes method 
		@Test
		public void retrieveAllNotesForNotebook() throws Exception {
			Mockito.when(noteService.retreiveAllNotes(Mockito.anyString())).thenReturn(mockNotes);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/notebooks/notebookName/notes").accept(
				MediaType.APPLICATION_JSON);

			MvcResult result = mockMvc.perform(requestBuilder).andReturn();
			
			MockHttpServletResponse response = result.getResponse();
			
			assertEquals(HttpStatus.OK.value(), response.getStatus());
		}
		
		// Unit testing the updateNote method
		@Test
		public void updateNoteTest() throws Exception {
		Mockito.doNothing().when(noteService).updateNote(Mockito.anyString(), Mockito.any(Note.class));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put(
				"/notebooks/notebookName/notes/title").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		
		assertNotSame(HttpStatus.OK.value(), response.getStatus());

		}
	
	// Unit testing the deleteNote method 
	@Test
	public void deleteNoteTest() throws Exception {
		Mockito.doNothing().when(noteService).deleteNote(Mockito.anyString());		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete
				("/notebooks/notebookName/notes/title").accept(MediaType.APPLICATION_JSON)
				.content(exampleNoteJson1)
				.contentType(MediaType.APPLICATION_JSON);
		
	    MvcResult result = mockMvc.perform(requestBuilder).andReturn(); 
	    
		MockHttpServletResponse response = result.getResponse();
		
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}

}
