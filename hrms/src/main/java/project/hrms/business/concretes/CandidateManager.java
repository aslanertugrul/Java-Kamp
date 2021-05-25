package project.hrms.business.concretes;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.adapters.concretes.FakeMernisRegisterAdapter;
import project.hrms.business.abstracts.CandidateService;
import project.hrms.business.abstracts.EmailService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.ErrorResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.CandidateDao;
import project.hrms.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private FakeMernisRegisterAdapter candidateCheckMernis;
	private  EmailService emailService;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao, FakeMernisRegisterAdapter candidateCheckMernis,
			EmailService emailService) {
		super();
		this.candidateDao = candidateDao;
		this.candidateCheckMernis = candidateCheckMernis;
		this.emailService = emailService;
	}

	public CandidateManager() {
		super();
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"İş arayanlar listelendi");
	}

	@Override
	public Result add(Candidate candidate) {
		
		
		if (candidateNameCheck(candidate)) 
			return new ErrorResult("İsim boş olamaz");
		else if (candidateSurnameCheck(candidate))
			return new ErrorResult("Soyad boş olamaz");
		else if (candidateBirthDateCheck(candidate))
			return new ErrorResult("Doğum tarihi geçersiz ve boş");
		else if (candidateEmailCheck(candidate))
			return new ErrorResult("Email boş olamaz");
		else if (candidatePasswordCheck(candidate)) 
			return new ErrorResult("Şifre boş olamaz");
		else if (candidateIdentityNumberCheck(candidate)) 
			return new ErrorResult("TC Kimlik no boş ve 11 elemanlıdan olamaz");
		else if (candidateCheckMernis.checkEntryPerson(candidate))
			return new ErrorResult("Kimlik doğrulama geçersiz");
		else if (!candidateIsExist(candidate))
			return new ErrorResult("Bu kimlik no veya email ile başka kullanıcı kayıtlı");
		else {
			this.candidateDao.save(candidate);
			return new SuccessResult("İş arayan hesabı oluşturuldu" + "  " + this.emailService.sendEmail(candidate).getMessage());
		}
	}
	
	private boolean candidateNameCheck (Candidate candidate) {
		if (candidate.getRealUserName().length()==0 || candidate.getRealUserName()==null)
			return true;
		else
			return false;
	}
	
	private boolean candidateSurnameCheck (Candidate candidate) {
		if (candidate.getRealUserSurname().length()==0 || candidate.getRealUserSurname()==null)
			return true;
		else
			return false;
	}
	
	private boolean candidateIdentityNumberCheck (Candidate candidate) {
		if (candidate.getCandidateIdentityNumber().length()!=11 || candidate.getCandidateIdentityNumber()==null)
			return true;
		else
			return false;
	}
	
	private boolean candidateBirthDateCheck (Candidate candidate) {
		if (candidate.getCandidateBirthDate()<1900 )
			return true;
		else
			return false;
	}
	
	private boolean candidateEmailCheck (Candidate candidate) {
		if (candidate.getUserEmail().length()==0 || candidate.getUserEmail()==null)
			return true;
		else
			return false;
	}
	
	private boolean candidatePasswordCheck (Candidate candidate) {
		if (candidate.getUserPassword().length()==0 || candidate.getUserPassword()==null)
			return true;
		else
			return false;
	}
	
	private boolean candidateIsExist (Candidate candidate)  {
		var candidateList=candidateDao.findAll();
		
		for (Candidate check : candidateList) {
			if (check.getUserEmail().equals(candidate.getUserEmail()))
				return false;
			else if (check.getCandidateIdentityNumber().equals(candidate.getCandidateIdentityNumber()))
				return false;
		}
		return true;
	}
	

}
