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
@NoArgsConstructor
@AllArgsConstructor
@Table(name="corporate_users") 

public class CorporateUser extends User {
		
	@Column(name="title") 
	private String corporateUserTitle;  
	 
	@Column(name="website")
	private String corporateUserWebsite;  
		
	@Column(name="number")
	private String corporateUserNumber; 
	

}
