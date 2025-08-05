package com.kartavya.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Post {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;
    
    private String content;
    
    private int likes;
    
    
	
    public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")  // This creates a foreign key column in Post table
    private User user;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

	public Post(int postId, String content, int likes, User user) {
		super();
		this.postId = postId;
		this.content = content;
		this.likes = likes;
		this.user = user;
	}
	
	

	public Post() {
		super();
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", content=" + content + ", user=" + user + "]";
	}
    
    
}
