package controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import models.PostTitle;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * A forum micro service?
 * @author Haoyuan Huang
 *
 */
public class ForumController extends Controller {
	public static List<PostTitle> fake = new ArrayList<PostTitle> (
			Arrays.asList(
					new PostTitle(),
					new PostTitle(),
					new PostTitle(),
					new PostTitle(),
					new PostTitle(),
					new PostTitle(),
					new PostTitle(),
					new PostTitle(),
					new PostTitle(),
					new PostTitle(),
					new PostTitle(),
					new PostTitle(),
					new PostTitle(),
					new PostTitle(),
					new PostTitle(),
					new PostTitle(),
					new PostTitle(),
					new PostTitle(),
					new PostTitle(),
					new PostTitle(),
					new PostTitle(),
					new PostTitle(),
					new PostTitle(),
					new PostTitle(),
					new PostTitle(),
					new PostTitle(),
					new PostTitle(),
					new PostTitle(),
					new PostTitle(),
					new PostTitle(),
					new PostTitle(),
					new PostTitle(),
					new PostTitle(),
					new PostTitle(),
					new PostTitle(),
					new PostTitle(),
					new PostTitle(),
					new PostTitle(),
					new PostTitle(),
					new PostTitle(),
					new PostTitle(),
					new PostTitle(),
					new PostTitle(),
					new PostTitle(),
					new PostTitle()
			));

	public static Result getPosts () {
		return ok(forumEntrance.render(getPagesHelper(), getPostTitlesHelper(1)));
	}

	public static Result getPostsAtPage (Integer page) {
		if (page < 1 || page > getTotalPagesHelper())
			page = 1;
		return ok(forumEntrance.render(getPagesHelper(), getPostTitlesHelper(page)));
	}

	public static int getTotalPagesHelper() {
		return fake.size() % 10;
	}

	public static List<Integer> getPagesHelper() {
		int count = getTotalPagesHelper();
		List<Integer> numbers = new ArrayList<> ();
		for (int i = 1; i <= count; i ++ ) {
			numbers.add(i);
		}
		return numbers;
	}

	public static List<PostTitle> getPostTitlesHelper (int page) {
		int start = (page - 1) * 10;
		int end = start + 10;
		return fake.subList(start, Math.min(end, fake.size()));
	}
}
