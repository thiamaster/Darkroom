package br.com.darkroom.model;

import javax.persistence.*;
	
@Entity
@Table(name="message")
public class Message {
	public Message(long forumid, long userid){
		this.forumId = forumid;
		this.userId = userid;
	}
	
	
	@Id
	@Column(name = "message_id")
	private long id;
	
	@JoinColumn(name = "user_id")
	private long userId;
	
	@Column(name = "message_description")
	private String description;
	
	@Column(name = "message_title")
	private String title;

	@JoinColumn(name = "forum_id")
	private long forumId;
	
	
	public long getForumId() {
		return forumId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getId() {
		return id;
	}

	public long getUserId() {
		return userId;
	}
	
}
