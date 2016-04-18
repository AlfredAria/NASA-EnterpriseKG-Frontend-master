package models;

import java.util.List;

public class DetailedForumTopic {
  private ForumPost post;
  private List<ForumComment> comments;
  
  public DetailedForumTopic(ForumPost post, List<ForumComment> comments) {
    this.post = post;
    this.comments = comments;
  }
}
