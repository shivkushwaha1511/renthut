package models;

public class Message {
	private int messageId;
	private User userId;
	private PropertyPost postId;
	private String message;
	private String clock;
	private boolean who;
	
	public int getMessageId() {
		return messageId;
	}
	
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	
	public User getUserId() {
		return userId;
	}
	
	public void setUserId(User userId) {
		this.userId = userId;
	}
	
	public PropertyPost getPostId() {
		return postId;
	}
	
	public void setPostId(PropertyPost postId) {
		this.postId = postId;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getClock() {
		return clock;
	}
	
	public void setClock(String clock) {
		this.clock = clock;
	}
	
	public boolean isWho() {
		return who;
	}
	
	public void setWho(boolean who) {
		this.who = who;
	}
}