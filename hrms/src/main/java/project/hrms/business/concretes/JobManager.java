package project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.JobService;
import project.hrms.dataAccess.abstracts.JobDao;
import project.hrms.entities.concretes.JobPosition;

@Service
public class JobManager implements JobService {

	private JobDao jobDao;
	
	@Autowired
	public JobManager(JobDao jobDao) {
		super();
		this.jobDao = jobDao;
	}

	@Override
	public List<JobPosition> getAll() {
		return this.jobDao.findAll();
	}



}
