package api.Endpoints;
import static io.restassured.RestAssured.*;

import api.Payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {
	
	
	public static Response createUser(User payload) {
		
		Response response =given()
					.contentType(ContentType.JSON)
						.body(payload)
						.accept("application/json")
				
					.when()
						.post(Routes.post_url);
		
						return response;
	
	}	
		
	public static Response  readUser(String userName) {
		
				Response response =given()
							.pathParam("username", userName)
		
								.when()
									.get(Routes.get_url);
		
				return response;
	}
		

public static Response updateUser(User payload, String useName) {
		
		Response response =given()
					.pathParam("username", useName)
					.contentType(ContentType.JSON)
					.accept("application/json")
						.body(payload)
			.when()
						.put(Routes.update_url);
		
						return response;
	
	}	

public static Response deleteUser(String useName) {
	
	Response response =given()
				.pathParam("username", useName)
							
				.when()
					.delete(Routes.delete_url);
	
					return response;

}	
		
	
	
}
