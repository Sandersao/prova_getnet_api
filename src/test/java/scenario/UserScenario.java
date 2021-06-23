package scenario;

import java.util.ArrayList;

import org.junit.Test;

import dto.UserDto;
import io.restassured.response.Response;

public class UserScenario extends HelperClass {

	@Test
	public void readUserSingle() {
		ArrayList<UserDto> users = new ArrayList<UserDto>();
		users.add(this.userValid);
		for (UserDto user : users) {
			Response response = requisition.readUserSingle(user);
			validation.readUserSingle(response, user);
		}
	}
}
