package controllers;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import models.DetailedForumTopic;
import models.ForumComment;
import models.ForumTopic;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import utils.Constants;
import utils.RESTfulCalls;
import views.html.detailedForumTopic;

public class ForumTopicController extends Controller {
  final static Form<ForumComment> forumCommentForm = Form.form(ForumComment.class);

  public static Result showDetailedTopic_test(Integer id) {
    DetailedForumTopic detailed = new DetailedForumTopic(new ForumTopic(),
        new ArrayList<ForumComment>());

    detailed.topic = new ForumTopic(1, "Haoyuan", "Sep 29, 2015, 9:12 PM", "this is tile", "A service-oriented architecture (SOA) is an architectural pattern in computer software design in which application components provide services to other components via a communications protocol, typically over a network. The principles of service-orientation are independent of any vendor, product or technology.[1]\nA service is a self-contained unit of functionality, such as retrieving an online bank statement.[2] By that definition, a service is an operation that may be discretely invoked. However, in the Web Services Description Language (WSDL), a service is an interface definition that may list several discrete services/operations. And elsewhere, the term service is used for a component that is encapsulated behind an interface. This widespread ambiguity is reflected in what follows.\nServices can be combined to provide the functionality of a large software application.[3] SOA makes it easier for software components on computers connected over a network to cooperate. Every computer can run any number of services, and each service is built in a way that ensures that the service can exchange information with any other service in the network without human interaction and without the need to make changes to the underlying program itself.");
    detailed.comments = new ArrayList<ForumComment>();
    detailed.comments.add(new ForumComment(1, 1, "Yuanchen", "Haoyuan", "comment content 1", "Sep 30, 2015, 9:12 AM"));
    detailed.comments.add(new ForumComment(2, 1, "Yuanchen", "Haoyuan", "comment content 2", "Sep 31, 2015, 20:12 PM"));
    detailed.comments.add(new ForumComment(2, 1, "Haoyun", "Haoyuan", "comment content 3", "Oct 1, 2015, 22:02 PM"));
    detailed.comments.add(new ForumComment(2, 1, "Xingyu", "Haoyuan", "comment content 4", "Nov 12, 2015, 23:12 PM"));

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
    ForumTopic forumTopic = new ForumTopic();
    forumTopic.setId(topicJson.path("id").asInt());
    forumTopic.setUserName(topicJson.path("userName").asText());
    forumTopic.setTimestamp(topicJson.path("timestamp").asText());
    forumTopic.setTitle(topicJson.path("title").asText());
    forumTopic.setContent(topicJson.path("content").asText());
    return forumTopic;
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
    ForumComment forumComment = new ForumComment();

    forumComment.setCommentId(commentJson.path("commentId").asInt());
    forumComment.setTopicId(commentJson.path("topicId").asInt());
    forumComment.setUserName(commentJson.path("userName").asText());
    forumComment.setReplyTo(commentJson.path("replyTo").asText());
    forumComment.setContent(commentJson.path("content").asText());
    forumComment.setTimestamp(commentJson.path("timestamp").asText());

    return forumComment;
  }
}
