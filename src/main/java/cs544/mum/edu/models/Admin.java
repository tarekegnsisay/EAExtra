package cs544.mum.edu.models;

import javax.persistence.*;

@Entity
public class Admin  {
    
	@Id @GeneratedValue
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	@Enumerated(EnumType.STRING)
	private UserRole userRole;
    
	public Admin(){
		
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

}
