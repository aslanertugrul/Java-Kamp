package project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.JobTitleService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.ErrorResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.JobTitleDao;
import project.hrms.entities.concretes.Candidate;
import project.hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService {

	private JobTitleDao jobTitleDao;
	
	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}

	public JobTitleManager() {
		super();
	}

	@Override
	public DataResult<List<JobTitle>> getAll() {
		return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findAll(),"İşler listelendi");
	}


	public Result add(JobTitle jobTitle) {
		if (!jobTitleIsExist(jobTitle))
			return new ErrorResult("Bu iş mevcuttur, tekrar girilemez");
		else {
			this.jobTitleDao.save(jobTitle);
			return new SuccessResult("İş kaydedildi");
		}
	}
	
	private boolean jobTitleIsExist (JobTitle jobTitle) {
		var jobTitleList=jobTitleDao.findAll();
		
		for ( JobTitle check : jobTitleList) {
			if (check.getJobDetail().equals(jobTitle.getJobDetail()))
					return false;
		}
		return true;
	}
	



}
