package project.hrms.business.concretes;

import project.hrms.business.abstracts.EmailService;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.entities.concretes.User;

public class EmailManager implements EmailService {

	@Override
	public Result sendEmail(User user) {
		return new SuccessResult("Email başarıyla gönderildi: " + user.getUserEmail());
	}

}
