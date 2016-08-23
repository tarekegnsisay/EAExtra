package cs544.mum.edu.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Volunteer {

	@Id
	@GeneratedValue
	private int id;

	private String firstName;

	private String lastName;

	@Enumerated(EnumType.STRING)
	private UserRole userRole;
	
	private String description;

	@OneToOne(cascade = CascadeType.PERSIST)
	private Task task;
    
	public Volunteer(){
		
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	

}
