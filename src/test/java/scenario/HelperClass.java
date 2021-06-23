package scenario;

import dto.UserDto;
import requisition.UserRequisition;
import validation.UserValidation;

public class HelperClass {
	UserValidation validation = new UserValidation();
	UserRequisition requisition = new UserRequisition();
	UserDto userValid = new UserDto();
}
