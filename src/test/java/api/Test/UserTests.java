package api.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;
import com.github.javafaker.Faker;


import api.Endpoints.UserEndPoints;
import api.Payload.User;
import io.restassured.response.Response;


public class UserTests {
	
	Faker fk;
	User userpayload;
	public  Logger logger;
		
	@BeforeClass
	public void  setupData() {
		
		fk = new Faker();
		userpayload = new User();
		
		userpayload.setId(fk.idNumber().hashCode());
		userpayload.setUsername(fk.name().fullName());
		userpayload.setFirstName(fk.name().firstName());
		userpayload.setLastName(fk.name().lastName());
		userpayload.setEmail(fk.internet().safeEmailAddress());
		userpayload.setPassword(fk.internet().password(5, 10));
		userpayload.setPhone(fk.phoneNumber().cellPhone());
		
		logger = LogManager.getLogger(this.getClass());
		
	}
	
		@Test(priority=1)
		public  void testPostUser() {
		
		logger.info("******* Creating User *******************");
		Response response =UserEndPoints.createUser(userpayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("******* User is Created  *******************");	
	}
	
		@Test(priority =2)
		public void  testGetUserByName() {
			logger.info("******* Reading User  info *******************");
			Response response =UserEndPoints.readUser(this.userpayload.getUsername());
			response.then().log().all();
			Assert.assertEquals(response.getStatusCode(), 200);
			logger.info("******* User info is displayed*******************");
		}
		
		@Test(priority=3 )
		public void  testUpdateUserByName() {
			logger.info("******* Updating  User *******************");
			userpayload.setFirstName(fk.name().firstName());
			userpayload.setLastName(fk.name().lastName());
			userpayload.setEmail(fk.internet().safeEmailAddress());
			
			Response response =UserEndPoints.updateUser(userpayload,  this.userpayload.getUsername());
			//response.then().log().all();
			response.then().log().body();
			Assert.assertEquals(response.getStatusCode(), 200);
			logger.info("******* User is Updated *******************");
			
			Response response2 =UserEndPoints.readUser(this.userpayload.getUsername());
			response.then().log().all();
			response.then().log().body();
			Assert.assertEquals(response.getStatusCode(), 200);
			System.out.println("User data is updated");
			
		}
	
		@Test(priority =4)
		public void   testDeleteUserByName() {
			
			logger.info("******* Deleting User *******************");
			Response response =UserEndPoints.deleteUser(this.userpayload.getUsername());
			response.then().log().all();
			Assert.assertEquals(response.getStatusCode(), 200);
			logger.info("******* User  is deleted *******************");
		}
	

}
