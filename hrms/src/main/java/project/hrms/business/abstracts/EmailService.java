package project.hrms.business.abstracts;

import org.springframework.stereotype.Service;

import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.User;


public interface EmailService {
	Result sendEmail(User user);
}
