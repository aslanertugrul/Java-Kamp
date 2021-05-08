package eCommerce.core.googleEmail;

import eCommerce.amazonEmail.AmazonMailManager;
import eCommerce.core.EmailService;
import eCommerce.core.amazonEmail.AmazonMailManagerAdapter;
import eCommerce.googleEmail.GoogleMailManager;

public class GoogleMailManagerAdapter implements EmailService {

	private GoogleMailManager googleMailManager;
	
	
	public GoogleMailManagerAdapter() {
		super();
		this.googleMailManager = new GoogleMailManager();
	}


	
	@Override
	public void send(String email, String message) {
		googleMailManager.send(email, message);
	}

}
