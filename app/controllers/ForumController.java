package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.PostTitle;
import play.mvc.Controller;
import play.mvc.Result;
import utils.Constants;
import utils.RESTfulCalls;

import java.util.ArrayList;
import java.util.List;
import views.html.forumEntrance;

/**
 * A forum micro service?
 * @author Haoyuan Huang
 *
 */
public class ForumController extends Controller {

	public static Result getPosts () {
        JsonNode node = RESTfulCalls.getAPI(Constants.URL_HOST
                + Constants.CMU_BACKEND_PORT
                + "/forum/getPost");
        List<PostTitle> titles = new ArrayList<>();
        if (node.isArray()) {
            for (final JsonNode objNode : node) {
//                objNode.findPath("ratings");
                titles.add(new PostTitle(0, 0,
                        objNode.findPath("postTitle").asText(),
                        "Post"
                ));
            }
        }

		return ok(forumEntrance.render(getPagesHelper(20), titles));

	}
	
	public static Result getPostsAtPage (Integer page) {
        return ok("0");
//		return ok(forumEntrance.render(getPagesHelper(), getPostTitlesHelper(page)));
	}

	public static List<Integer> getPagesHelper(int numPosts) {
		int count = numPosts % 10;
		List<Integer> numbers = new ArrayList<> (); 
		for (int i = 1; i <= count; i ++ ) {
			numbers.add(i);
		}
		return numbers;
	}

}
