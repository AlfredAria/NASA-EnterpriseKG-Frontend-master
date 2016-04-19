package models;

import java.util.List;

public class DetailedForumTopic {
  public ForumTopic topic;
  public List<ForumComment> comments;
  
  public DetailedForumTopic() {
    
  }
  
  public DetailedForumTopic(ForumTopic topic, List<ForumComment> comments) {
    this.topic = topic;
    this.comments = comments;
  }
}
