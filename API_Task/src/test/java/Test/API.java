package Test;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import DataLoader.LoadProperties;
import io.restassured.path.json.JsonPath;

public class API {
	String baseAPI = LoadProperties.data.getProperty("BasicAPI");
	String userID = LoadProperties.data.getProperty("UserID");
	@Test 
	public void getUserMail() {
		ArrayList<String>  response = 
				given()
					.param("id", userID)
					.header("Content-type", " application/json; charset=UTF-8")
				.when()
					.get(baseAPI+"users").then().extract().path("email");
		for(String email:response){
		    System.out.println("The email address of user ID "+userID+" is: "+email);
		}
	}
	
	@Test 
	public void getUsersAssociatedPosts() {
		ArrayList<Integer>  response = 
				given()
					.param("userId", userID)
					.header("Content-type", " application/json; charset=UTF-8")
				.when()
					.get(baseAPI+"posts").then().extract().path("id");
		for(int id:response){
		    //System.out.println("The post id for user ID "+userID+" is: "+id);
		    Assert.assertTrue(id<=100 && id >=1);
		}
	}
	@Test 
	public void doAPost() {
		Map<String, Object> post = new HashMap<>();
        post.put("userId", userID);
        post.put("title", "non-empty title");
        post.put("body", "non-empty body");
		int statusCode = 
				given()
					.header("Content-type", " application/json; charset=UTF-8")
					.body(post)
				.when()
					.post(baseAPI+"posts").then().extract().statusCode();
		Assert.assertTrue(statusCode!=400);
		JsonPath response = 
				given()
					.header("Content-type", " application/json; charset=UTF-8")
					.body(post)
				.when()
					.post(baseAPI+"posts").then().extract().jsonPath();
		
		
		Assert.assertNotNull(response.get("id"));
		Assert.assertTrue( response.get("userId").equals(userID) );
		
		}
	

}
