package com.NevernoteAPI;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.NevernoteAPI.Notebook.NotebookController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTestNotebookController {
	
	@Autowired
	private NotebookController notebookController;

	@Test
	public void notebookSmokeTest() throws Exception{
		assertThat(notebookController).isNotNull();
	}

	
}
