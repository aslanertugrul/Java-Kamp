package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.entities.concretes.JobPosition;

public interface JobService {
	
	List<JobPosition> getAll();
	
}
