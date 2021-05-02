package Interfaces;

import Fields.Users;

public interface UserServices {

	abstract void register(Users user);
	abstract void update(Users user,String newNickName);
	abstract void delete(Users user);
	
}
