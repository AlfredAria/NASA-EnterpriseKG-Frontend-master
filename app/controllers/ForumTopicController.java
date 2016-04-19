package controllers;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import models.DetailedForumTopic;
import models.ForumComment;
import models.ForumTopic;
import models.Publications;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import utils.Constants;
import utils.RESTfulCalls;
import views.html.allPublications;
import views.html.detailedForumTopic;

public class ForumTopicController extends Controller {
  final static Form<ForumComment> forumCommentForm = Form.form(ForumComment.class);

  public static Result showDetailedTopic_test(Integer id) {
    DetailedForumTopic detailed = new DetailedForumTopic(new ForumTopic(),
        new ArrayList<ForumComment>());

    detailed.topic = new ForumTopic(1, "Haoyuan", "Sep 29, 2015, 9:12 PM", "this is tile", "this is content");
    detailed.comments = new ArrayList<ForumComment>();
    detailed.comments.add(new ForumComment(1, 1, "Yuanchen", "Haoyuan", "comment content 1", "Sep 30, 2015, 9:12 AM"));
    detailed.comments.add(new ForumComment(2, 1, "Nan", "Yuanchen", "comment content 2", "Sep 31, 2015, 20:12 PM"));
    detailed.comments.add(new ForumComment(2, 1, "Nan2", "Yuanchen", "comment content 2", "Sep 31, 2015, 20:12 PM"));
    detailed.comments.add(new ForumComment(2, 1, "Nan3", "Yuanchen", "comment content 2", "Sep 31, 2015, 20:12 PM"));

    return ok(detailedForumTopic.render(detailed, forumCommentForm));
  }

  public static Result showDetailedTopic(Integer id) {
    JsonNode detailedForumTopicNode = RESTfulCalls.getAPI(Constants.URL_HOST
        + Constants.CMU_BACKEND_PORT + Constants.FORUM_POST_DETAIL + id);

    DetailedForumTopic detailed = deserializeJsonToDetailedForumTopic(detailedForumTopicNode);
    return ok(detailedForumTopic.render(detailed, forumCommentForm));
  }
  
  public static DetailedForumTopic deserializeJsonToDetailedForumTopic(JsonNode detailedForumTopicJson) {
    DetailedForumTopic detailed = new DetailedForumTopic();
    
    if (detailedForumTopicJson == null || detailedForumTopicJson.has("error")) {
      return detailed;
    }
    
    detailed.topic = deserializeJsonToForumTopic(detailedForumTopicJson.path("topic"));
    detailed.comments = deserializeJsonToForumComments(detailedForumTopicJson.path("comments"));
    
    return detailed;
  }

  private static ForumTopic deserializeJsonToForumTopic(JsonNode topicJson) {
    // TODO Auto-generated method stub
    return null;
  }
  
  private static List<ForumComment> deserializeJsonToForumComments(JsonNode commentsJson) {
    List<ForumComment> comments = new ArrayList<ForumComment>();
    for (int i = 0; i < commentsJson.size(); i++) {
      JsonNode commentJson = commentsJson.path(i);
      ForumComment comment = deserializeJsonToForumComment(commentJson);
      comments.add(comment);
    }
    return comments;
  }
  
  private static ForumComment deserializeJsonToForumComment(JsonNode commentJson) {
    // TODO Auto-generated method stub
    return null;
  }
}
