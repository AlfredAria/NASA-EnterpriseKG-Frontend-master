package controllers;

import java.util.ArrayList;

import models.DetailedForumTopic;
import models.ForumComment;
import models.ForumPost;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.detailedForumTopic;

public class ForumTopicController extends Controller {
  final static Form<ForumComment> forumCommentForm = Form.form(ForumComment.class);
  
  public static Result showDetailedTopic() {
    DetailedForumTopic detailed = new DetailedForumTopic(
        new ForumPost(), new ArrayList<ForumComment>());

    return ok(detailedForumTopic.render(detailed, forumCommentForm));
  }
}
