package api.endpoints;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;

public class UserEndpoints2 {
	
	static ResourceBundle getURL() {
		ResourceBundle routes = ResourceBundle.getBundle("routes");
		return routes;
	}
	public static Response CreateUser(User Payload) {
		
		String post_url = getURL().getString("post_url");
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(Payload)
				
				.when()
					.post(post_url);
		
		return response;
				
	}
	
	public static Response GetUser(String username) {
		String get_url = getURL().getString("get_url");
		Response response = given()
				.pathParam("username", username)
								
				.when()
					.get(get_url);
		
		return response;
				
	}
	public static Response UpdateUser(User Payload, String username) {
		String update_url = getURL().getString("update_url");
		Response response = 
				given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", username)
				.body(Payload)
				
				.when()
					.put(update_url);
		
		return response;
				
	}
	
	public static Response DeleteUser(String username) {
		String delete_url = getURL().getString("delete_url");
		Response response = 
				given()
				.pathParam("username", username)
				
				.when()
					.delete(delete_url);
		
		return response;
				
	}
	
}
