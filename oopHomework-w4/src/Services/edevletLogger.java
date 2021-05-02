package Services;

import Fields.Users;
import Interfaces.Loggers;

public class edevletLogger implements Loggers {

	@Override
	public boolean log(Users user) {
		
		// e-devlet kontrol kodlarý
		
				boolean edevletCheck = true; // kontrol dönüþü. Simule için sürekli TRUE
				
				return edevletCheck;
	}

}
