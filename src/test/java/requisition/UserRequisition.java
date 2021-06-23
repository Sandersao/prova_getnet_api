package requisition;

import dto.UserDto;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UserRequisition {
	public UserRequisition() {
		RestAssured.baseURI = "https://reqres.in/api";
	}
	
	public Response readUserSingle(UserDto user) {
		try {
			if(user.getId() == null){
				return RestAssured
						.given()
						.contentType("application/json")
						.when()
						.get("/users")
						.then()
						.extract()
						.response();
			}else {
				return RestAssured
						.given()
						.contentType("application/json")
						.when()
						.get("/users/" + user.getId())
						.then()
						.extract()
						.response();
			}
		} catch (Exception e) {
			return null;
		}
	}
}
