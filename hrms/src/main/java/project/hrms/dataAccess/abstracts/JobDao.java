package project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import project.hrms.entities.concretes.JobPosition;

public interface JobDao extends JpaRepository<JobPosition, Integer> {

}
