package com.NevernoteAPI.Note;

import java.time.LocalDateTime;

//Spring MVC Model layer for Note class
public class Note {
	
	// fields
	private String title;
	private String body;
	private String[] tags;
	private String createdTime;
	private LocalDateTime lastModifiedtime;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String[] getTags() {
		return tags;
	}
	public void setTags(String[] tags) {
		this.tags = tags;
	}
	public String getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
	public LocalDateTime getLastModifiedtime() {
		return lastModifiedtime;
	}
	public void setLastModifiedtime(LocalDateTime lastModifiedtime) {
		this.lastModifiedtime = lastModifiedtime;
	}
	public Note(String title, String body, String[] tags, String createdTime, LocalDateTime lastModifiedtime) {
		super();
		this.title = title;
		this.body = body;
		this.tags = tags;
		this.createdTime = createdTime;
		this.lastModifiedtime = lastModifiedtime;
	}
	
	public Note() {
	}
	
}
