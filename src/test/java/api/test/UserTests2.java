package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints;
import api.endpoints.UserEndpoints2;
import api.payload.User;

import io.restassured.response.Response;

public class UserTests2 {
	Faker faker;
	User UserPayLoad;
	public Logger logger;
	
	@BeforeClass
	public void setupData() {
		faker = new Faker();
		UserPayLoad = new User();
		UserPayLoad.setId(faker.number().hashCode());
		UserPayLoad.setUsername(faker.name().username());
		UserPayLoad.setFirstName(faker.name().firstName());
		UserPayLoad.setLastName(faker.name().lastName());
		UserPayLoad.setEmail(faker.internet().safeEmailAddress());
		UserPayLoad.setPassword(faker.internet().password(5, 10));
		UserPayLoad.setPhone(faker.phoneNumber().cellPhone());
		
		logger = LogManager.getLogger(this.getClass());
		
	}
	
	@Test(priority=1)
	public  void testPostUser() {
		
		logger.info("*********************creating user****************************");
		Response response = UserEndpoints2.CreateUser(UserPayLoad);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("*********************created user****************************");
						
	}
	
	@Test(priority=2)
	public void testGetUserByName() {
		logger.info("*********************getting user by name****************************");
		Response response = UserEndpoints2.GetUser(UserPayLoad.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=3)
	public void testUpdateUserByName() {
		logger.info("*********************updating user****************************");
		UserPayLoad.setFirstName(faker.name().firstName());
		UserPayLoad.setLastName(faker.name().lastName());
		UserPayLoad.setEmail(faker.internet().safeEmailAddress());
		Response responseAfterUpdate = UserEndpoints2.UpdateUser(UserPayLoad, UserPayLoad.getUsername());
		responseAfterUpdate.then().log().all();
		Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
	}
	
	@Test(priority=4)
	public void testDeleteUserByName() {
		logger.info("*********************deleting user****************************");
		Response response = UserEndpoints2.DeleteUser(UserPayLoad.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
}
