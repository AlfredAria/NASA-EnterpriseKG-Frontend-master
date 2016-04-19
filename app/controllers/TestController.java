package controllers;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import play.mvc.Result;
import utils.Constants;
import utils.RESTfulCalls;
import utils.RESTfulCalls.ResponseType;
import views.html.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import models.Author;
import models.BugReport;
import models.ForumPost;

/**
 * @author Yuanchen Bai
 * @version Apr 11, 2016 8:33:34 PM
 */
public class TestController extends Controller{
	final static Form<ForumPost> postForm = Form.form(ForumPost.class);
	
	public static Result GetPostPage(){
		return ok(createPost.render(postForm));
	}
	
	public static Result CancelPost(){
		return ok();
	}
	
	public static Result CreatePost() {
		Form<ForumPost> filledForm = postForm.bindFromRequest();
		
		ObjectNode jsonData = Json.newObject();
		try {
			jsonData.put("title", filledForm.get().getPostTitle());
			jsonData.put("link", filledForm.get().getLink());
			jsonData.put("content", filledForm.get().getPostContent());
			jsonData.put("timestamp", filledForm.get().getTimeStamp());
			
			System.out.println(jsonData);
			// POST Climate Service JSON data
			JsonNode response = RESTfulCalls.postAPI(Constants.URL_HOST + Constants.CMU_BACKEND_PORT 
					+ Constants.ADD_NEW_POST, jsonData);
			
			// flash the response message
			Application.flashMsg(response);
			
//			return redirect(routes.BugReportController.list());
		}
		catch (IllegalStateException e) {
			e.printStackTrace();
			Application.flashMsg(RESTfulCalls
					.createResponse(ResponseType.CONVERSIONERROR));
		} catch (Exception e) {
			e.printStackTrace();
			Application.flashMsg(RESTfulCalls
					.createResponse(ResponseType.UNKNOWN));
		}
		
		return ok(createPost.render(filledForm));
		
	}
}
