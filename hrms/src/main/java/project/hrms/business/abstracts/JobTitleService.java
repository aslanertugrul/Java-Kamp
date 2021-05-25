package project.hrms.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.JobTitle;


public interface JobTitleService {
	
	DataResult<List<JobTitle>> getAll();
	Result add(JobTitle jobTitle);
	
}
