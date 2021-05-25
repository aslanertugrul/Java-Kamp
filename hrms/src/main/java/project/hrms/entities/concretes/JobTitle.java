package project.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="job_titles")

public class JobTitle{

	@Id
	@GeneratedValue
	@Column(name="job_id")
	private int jobID;
	
	@Column(name="job_detail")
	private String jobDetail;

	public JobTitle() {
		super();
	}
	
	public JobTitle(int jobID, String jobDetail, int employerID) {
		super();
		this.jobID = jobID;
		this.jobDetail = jobDetail;
	}

	
	
}
