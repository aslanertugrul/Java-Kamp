package Utils;

import Fields.Users;
import Interfaces.Loggers;

public class Validation {

	public static boolean validateLogin (Users user, Loggers logger) {
		
		boolean validationCheck = logger.log(user);
		
		if ((user.getUserIdentity().length()==11 && user.getUserBirthDate()<=2003) && validationCheck)
			return true;
		else 
			return false;
	};
	
	public static boolean validateUpdate (Users user, String nickName) {
		
		if (!user.getNickName().equals(nickName))
			return true;
		else 
			return false;
	};
	
	public static boolean validateDelete (Users user) {
		
		return true;
		
	};
}

