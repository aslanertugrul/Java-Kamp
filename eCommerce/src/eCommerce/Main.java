package eCommerce;

import java.util.List;

import eCommerce.DataAccess.concretes.InMemoryUserDao;
import eCommerce.business.abstracts.UserService;
import eCommerce.business.concretes.AuthManager;
import eCommerce.business.concretes.UserManager;
import eCommerce.core.amazonEmail.AmazonMailManagerAdapter;
import eCommerce.core.googleEmail.GoogleMailManagerAdapter;
import eCommerce.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		
		InMemoryUserDao inMemoryUserDao = new InMemoryUserDao();
		AuthManager authManager = new AuthManager(new UserManager(inMemoryUserDao,
					new AmazonMailManagerAdapter()));
		
		User user1 = new User(4,"Ahmet","Aslan","ahmetaslan61@gmail.com","12345",true);
		User user2 = new User(5,"Zeki","Aslan","zekiaslan61@gmail.com","12345",true);
		
		authManager.register(user1);
		authManager.register(user2);
		UserManager userManager = new UserManager(inMemoryUserDao, new GoogleMailManagerAdapter());
		userManager.add(user1);
		userManager.add(user2);
		userManager.getAll();
		
		
	}

}
