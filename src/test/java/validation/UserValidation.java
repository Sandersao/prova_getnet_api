package validation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import dto.UserDto;
import io.restassured.response.Response;

public class UserValidation {

	public void readUserSingle(Response response, UserDto user) {
		this.checkResponse(response);
		try {
			assertEquals("Unexpected status code", 200, response.statusCode());
			assertEquals("Incorrect return of parameter \"id\"", user.getId(),
					response.jsonPath().getString("data.id"));
			assertEquals("Incorrect return of parameter \"first_name\"", user.getNomeFirst(),
					response.jsonPath().getString("data.first_name"));
			assertEquals("Incorrect return of parameter \"last_name\"", user.getNomeLast(),
					response.jsonPath().getString("data.last_name"));
			assertEquals("Incorrect return of parameter \"email\"", user.getEmail(),
					response.jsonPath().getString("data.email"));
			assertEquals("Incorrect return of parameter \"avatar\"", user.getAvatar(),
					response.jsonPath().getString("data.avatar"));
		} catch (Exception e) {
			fail("Error not specified in the documentation");
		}
	}

	private void checkResponse(Response response) {
		if (response == null) {
			fail("The application seams not to be running");
		}
	}
}
