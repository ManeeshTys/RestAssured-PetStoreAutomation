package api.endpoints;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;

public class UserEndpoints {
	public static Response CreateUser(User Payload) {
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(Payload)
				
				.when()
					.post(Routes.post_url);
		
		return response;
				
	}
	
	public static Response GetUser(String username) {
		Response response = given()
				.pathParam("username", username)
								
				.when()
					.get(Routes.get_url);
		
		return response;
				
	}
	public static Response UpdateUser(User Payload, String username) {
		Response response = 
				given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", username)
				.body(Payload)
				
				.when()
					.put(Routes.put_url);
		
		return response;
				
	}
	
	public static Response DeleteUser(String username) {
		Response response = 
				given()
				.pathParam("username", username)
				
				.when()
					.delete(Routes.delete_url);
		
		return response;
				
	}
	
}
