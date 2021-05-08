package eCommerce.business.concretes;

import java.util.List;

import eCommerce.DataAccess.abstracs.UserDao;
import eCommerce.business.abstracts.UserService;
import eCommerce.core.EmailService;
import eCommerce.entities.concretes.User;

public class UserManager implements UserService {

	private UserDao userDao;
	private EmailService emailService; 

	public UserManager(UserDao userDao, EmailService emailService) {
		super();
		this.userDao = userDao;
		this.emailService = emailService;
	}

	@Override
	public void add(User user) {
		if (userValidate(user)) {
			userDao.add(user);
			emailService.send(user.getEmail(), "Kayýt oldunuz");
		}
		
	}

	@Override
	public void update(User user) {
		if (userValidate(user)) {
			userDao.update(user);
		}
		
	}

	@Override
	public void delete(int userId) {
		userDao.delete(userId)	;
	}

	@Override
	public User get(String email) {
		return userDao.get(email);
	}

	@Override
	public List<User> getAll() {
		for (User user : userDao.getAll()) {
			System.out.println(user.getName() + " " + user.getSurname());
		}
		return userDao.getAll();
	}
	
	public boolean userValidate (User user) {
		if ((user.getName().length()>2) && user.getSurname().length()>2) {
			return true;
		} else {
			System.out.println("Ad ve soyad iki karakterden kýsa olamaz");
			return false;
		}

	}
	
}
