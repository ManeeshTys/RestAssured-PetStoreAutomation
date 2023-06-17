package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndpoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTests {
	
	@Test(priority=1, dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void testpostuser(String UserID, String Username, String FirstName, String LastName, 
			String Email, String Password, String Phone) {
		User UserPayLoad = new User();
		UserPayLoad.setId(Integer.parseInt(UserID));
		UserPayLoad.setUsername(Username);
		UserPayLoad.setFirstName(FirstName);
		UserPayLoad.setLastName(LastName);
		UserPayLoad.setEmail(Email);
		UserPayLoad.setPassword(Password);
		UserPayLoad.setPhone(Phone);
		
		Response response = UserEndpoints.CreateUser(UserPayLoad);
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
	}
	
	@Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
	public void testDeleteUser(String Username) {
		Response response = UserEndpoints.DeleteUser(Username);
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}

}
