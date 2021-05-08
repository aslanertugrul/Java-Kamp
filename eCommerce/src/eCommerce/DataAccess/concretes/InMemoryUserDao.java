package eCommerce.DataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerce.DataAccess.abstracs.UserDao;
import eCommerce.entities.concretes.User;

public class InMemoryUserDao implements UserDao {

	private List<User> users = new ArrayList<User>();
	
	public InMemoryUserDao() {
		User user1 = new User(1,"Ertuðrul","Aslan","ertugrulaslan61@gmail.com","12345",true);
		User user2 = new User(2,"Lütfi","Arslan","lutfiaslan@gmail.com","12345",true);
		User user3 = new User(3,"Esra","Aslan","esraslan61@gmail.com","1245",true);
		
		users.add(user1);
		users.add(user2);
		users.add(user3);
	}
	
	
	@Override
	public void add(User user) {
		System.out.println("Kaydedildi : " + user.getEmail());
		users.add(user);
	}

	@Override
	public void update(User user) {
		User userUpdate=users.stream()
					.filter(u->u.getId()==user.getId())
					.findFirst()
					.orElse(null);
		
		userUpdate.setEmail(user.getEmail());
		userUpdate.setName(user.getName());
		userUpdate.setSurname(user.getSurname());
		userUpdate.setPassword(user.getPassword());
		userUpdate.setId(user.getId());
		userUpdate.setVerify(user.isVerify());
	}

	@Override
	public void delete(int userId) {
		User userDelete = users.stream()
				.filter(u->u.getId()==userId)
				.findFirst()
				.orElse(null);
		users.remove(userDelete);
	}

	@Override
	public List<User> getAll() {
		return users;
	}

	@Override
	public User get(String email) {
		User user = users.stream()
				.filter(u->u.getEmail()==email)
				.findFirst()
				.orElse(null);
		return user;
	}

	
}
