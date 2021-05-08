package eCommerce.core;

import eCommerce.DataAccess.concretes.InMemoryUserDao;
import eCommerce.business.abstracts.UserService;
import eCommerce.entities.concretes.LoginDto;
import eCommerce.entities.concretes.User;

public class GoogleAuthManagerAdapter implements ExternalAuthService {

	private UserService userService;
	private InMemoryUserDao inMemoryUserDao;
	
	public GoogleAuthManagerAdapter(UserService userService, InMemoryUserDao inMemoryUserDao) {
		super();
		this.userService = userService;
		this.inMemoryUserDao = inMemoryUserDao;
	}

	@Override
	public void register(String email) {
		if (userExists(email)==false) {
			userService.add(null);
		} 
		else {
			User user = userService.get(email);
			
			LoginDto dto = new LoginDto();
			dto.setEmail(user.getEmail());
			dto.setPassword(user.getPassword());
			
			login(dto);
		}
		
	}

	@Override
	public boolean userExists(String email) {
		if (userService.get(email)!=null) {
			return true;
		}
		return false;
		
	}

	@Override
	public void login(LoginDto dto) {
		if (dto!=null && dto.getPassword().equals(dto.getPassword())) {
			System.out.println("Baþarýyla giriþ yaptýnýz");
		}
		
		else {
			System.out.println("Kullanýcý adý veya þifren yanlýþ");
		}
		
	}

	
	
}
