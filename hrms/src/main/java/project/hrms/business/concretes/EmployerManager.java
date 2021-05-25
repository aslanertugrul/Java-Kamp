package project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import project.hrms.business.abstracts.EmailService;
import project.hrms.business.abstracts.EmployerService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.ErrorResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.EmployerDao;
import project.hrms.entities.concretes.Employer;



@Service
@NoArgsConstructor
public class EmployerManager implements EmployerService {


	private EmailService emailService;
	private EmployerDao employerDao;
	private String employerConfirmationStatus;

	@Autowired
	public EmployerManager(EmailService emailService, EmployerDao employerDao, String employerConfirmationStatus) {
		super();
		this.emailService = emailService;
		this.employerDao = employerDao;
		this.employerConfirmationStatus = employerConfirmationStatus;
	}



	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "iş verenler listelendi");
	}

	@Override
	public Result add(Employer employer) {

		if 		(!employerIsReal(employer))
			return new ErrorResult("Şirket websitesi ve mail domaini uyuşmuyor");
		else if (employerIsExist(employer))
			return new ErrorResult("İş veren profili zaten mevcut");
		/*else if (!employerIsAuthorized(employer))
			return new ErrorResult("HR onayı eksik.");*/
		else {
			this.employerDao.save(employer);
			this.employerIsAuthorized(employer);
			return new SuccessResult("İş veren profili oluşturuldu"+" , "+employerConfirmationStatus +" ,  " + this.emailService.sendEmail(employer).getMessage());
		}
			
	}

	public boolean employerIsExist (Employer employer) {
		var employerList=employerDao.findAll();
		
		for (Employer check : employerList) {
			if (check.getUserEmail().equals(employer.getUserEmail()))
				return true;
			
		}
		return false;
			
	}
	
	public boolean employerIsReal (Employer employer) {
		String brace1= "@";
		String brace2= "ww..";
		String[] website = employer.getCorporateUserWebsite().split(brace2,2);
		String[] mail = employer.getUserEmail().split(brace1);
		
		if ( website[1].equals(mail[1]) ) {
			return true;
		} else
			return false;
	}

	public void employerIsAuthorized (Employer employer) {
		if (employer.isEmployerIsConfirmed()==false)
			employerConfirmationStatus="HR onayı mevcut değil";
		else
			employerConfirmationStatus="HR onayı mevcut";
	}
	
	
}
