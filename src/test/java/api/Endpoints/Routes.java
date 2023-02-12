package api.Endpoints;

/*
 for Swagger  baseURI--> https://petstore.swagger.io/v2
 Create user(Post) : https://petstore.swagger.io/v2/user
Get usre(Get): https://petstore.swagger.io/v2/user/{username}
Update user(Put) : https://petstore.swagger.io/v2/user/{username}
Delete user (Delete) : https://petstore.swagger.io/v2/user/{username}
  */


public class Routes {

	//User Model: 
	public static String base_url = "https://petstore.swagger.io/v2";		//main domain URL
	public static String post_url =base_url+"/user";
	public static String get_url = base_url+"/user/{username}";
	public static String update_url =base_url+"/user/{username}";
	public static String delete_url =base_url+"/user/{username}";
	

	
	
}
