package com.NevernoteAPI;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.NevernoteAPI.Note.NoteController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTestNoteController {
	
	@Autowired
	private NoteController noteController;

	@Test
	public void noteSmokeTest() throws Exception{
		assertThat(noteController).isNotNull();
	}

	
}
