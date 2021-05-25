package project.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@Entity
@AllArgsConstructor
@Table(name="employers") 

public class Employer  extends CorporateUser {

	public Employer() {
		super();
	}
	
	@Column(name="IsConfirmed") 
	private boolean employerIsConfirmed; 
	
	
}
 