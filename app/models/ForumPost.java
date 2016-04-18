package models;

public class ForumPost {
	private long postId;
	private long userId;
	private String timestamp;
	private String postTitle;
	private String postContent;
	
	public ForumPost() {
		
	}
	
	public ForumPost(long userId, String timestamp,
			String postTitle, String postContent) {
		setUserId(userId);
		setTimestamp(timestamp);
		setPostTitle(postTitle);
		setPostContent(postContent);
	}

	public long getPostId() {
		return postId;
	}

	public void setPostId(long postId) {
		this.postId = postId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	
}
