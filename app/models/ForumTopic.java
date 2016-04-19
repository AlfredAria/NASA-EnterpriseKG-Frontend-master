package models;

public class ForumTopic {
	private Integer id;
	private String userName;
	private String timestamp;
	private String title;
	private String content;
	
	public ForumTopic() {
		
	}
	
	public ForumTopic(Integer id, String userName, String timestamp,
			String title, String content) {
		this.id = id;
		this.userName = userName;
		this.timestamp = timestamp;
		this.title = title;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserId(String userName) {
		this.userName = userName;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
