package Services;

import Fields.Users;
import Interfaces.Loggers;

public class edevletLogger implements Loggers {

	@Override
	public boolean log(Users user) {
		
		// e-devlet kontrol kodlar�
		
				boolean edevletCheck = true; // kontrol d�n���. Simule i�in s�rekli TRUE
				
				return edevletCheck;
	}

}
