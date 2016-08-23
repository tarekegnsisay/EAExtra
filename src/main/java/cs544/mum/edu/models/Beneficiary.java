package cs544.mum.edu.models;

import javax.persistence.*;

@Entity
public class Beneficiary {
	
	@Id @GeneratedValue
	private int id;
	
	private String beneficiaryName;
	
	private String description;
	
	@ManyToOne
	private Project project;
    
	public Beneficiary (){
		
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	
	

}
