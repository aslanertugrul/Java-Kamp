package eCommerce.business.concretes;

import eCommerce.business.abstracts.AuthService;
import eCommerce.business.abstracts.UserService;
import eCommerce.core.utils.Utils;
import eCommerce.entities.concretes.LoginDto;
import eCommerce.entities.concretes.User;

public class AuthManager implements AuthService{

	private UserService userService;
	
	public AuthManager(UserService userService) {
		super();
		this.userService = userService;
	}

	@Override
	public void register(User user) {
		if(userValidate(user) 
				&& passwordValidate(user.getPassword()) 
					&& userExists(user.getEmail())==false 
						&& Utils.emailValidate(user.getEmail()) ) {
			userService.add(user);
		}
		System.out.println("Kay�t ba�ar�s�z");
	}

	@Override
	public void verify (User user , String token) {
		if (user!=null && token.length()>20) {
			User existUser = userService.get(user.getEmail());
			existUser.setVerify(true);
			
			userService.update(existUser);
			System.out.println("Do�ruland�");
		}
		System.out.println("Do�rulanamad�");
		
	}

	@Override
	public boolean userExists(String email) {
		User user=userService.get(email);
		
		if (user==null) {
			return false;
		} else {
		System.out.println("Email mevcut : " + email);
		return true;
		}
	}
	
		

	@Override
	public void login(LoginDto dto) {
		User user = userService.get(dto.getEmail());
		
		if (user!=null && user.getPassword().equals(dto.getPassword())) {
			System.out.println("Ba�ar�l� giri� yapt�n�z");
		} else {
		System.out.println("Kullan�c� ad� veya �ifre yanl��");
		}	
	}

	public boolean userValidate (User user) {
		if (user!=null && !user.getName().isEmpty() && !user.getSurname().isEmpty() 
				&& user.getEmail().isEmpty() && !user.getPassword().isEmpty()) {
			return true;
		} else {
		return false;
		}
	}
	
	public boolean passwordValidate (String password) {
		if(password.length()>=6) {
			return true;
		} else {
			System.out.println("�ifreniz en az 6 karakter olmal�");
			return false;
		}
	}

	
}







