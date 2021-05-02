package Services;

import Fields.Users;
import Interfaces.UserServices;


public class UserManager implements UserServices {

	@Override
	public void register(Users user) {
		boolean check = Utils.Validation.validateLogin(user, new edevletLogger());
		
		if (check==true) {
			System.out.println("Kullanýcý oluþturuldu");
			writeUserDetail(user);
		}
		else 
			System.out.println(user.getUserName() + " " + user.getUserSurname() + " için kimlik numarasý veya dogum tarihi yanlýþ");
	}

	@Override
	public void update(Users user,String newNickName) {
		boolean check = Utils.Validation.validateLogin(user, new edevletLogger());
		
		if (check==true) {
			System.out.println("Nickname güncellendi");
			user.setNickName(newNickName);
			writeUserDetail(user);
		}
		else 
			System.out.println("Eski ve yeni nickname ayný olamaz");
	}

	@Override
	public void delete(Users user) {
		
		boolean check = Utils.Validation.validateLogin(user, new edevletLogger());
		
		if (check=true) {
			
			user.setNickName(null);
			user.setUserBirthDate(0);
			user.setuserID(0);
			user.setUserIdentity(null);
			user.setUserName(null);
			user.setUserSurname(null);
			System.out.println("Kullanýcý silindi");
		}
		
	}
	
	public void writeUserDetail (Users user) {
		System.out.println("" +
				user.getUserName() + "\n" +
				user.getUserSurname() + "\n" +
				user.getuserID() + "\n" +
				user.getNickName() + "\n"
				);
		
	}
}


