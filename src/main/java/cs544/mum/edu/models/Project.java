package cs544.mum.edu.models;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.persistence.*;
@Entity
public class Project {
	
	@Id @GeneratedValue
	private int id;
	
	private String projectName;
	
	private String description;
	
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	private String projectLocation;
	
	@Enumerated(EnumType.STRING)
	private  Status status;
	
	@OneToMany(mappedBy ="project")
	private List<Task> tasks = new ArrayList<Task>();;
	
	/*@OneToOne
	@JoinColumn(name="admin_id")
	private Admin createdBy;*/
	private static DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT,
			Locale.US);
	public Project(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStartDate() {
		return df.format(startDate);
	}

	public void setStartDate(String startDate) {
		try {
			this.startDate = df.parse(startDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getEndDate() {
		return df.format(endDate);
	}

	public void setEndDate(String endDate) {
		try {
			this.endDate = df.parse(endDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getProjectLocation() {
		return projectLocation;
	}

	public void setProjectLocation(String projectLocation) {
		this.projectLocation = projectLocation;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
   
	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	/*public Admin getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Admin createdBy) {
		this.createdBy = createdBy;
	}*/
	/* Collections Methods */
	public boolean addTask(Task task) {
		
		boolean success = false;
		if (tasks.add(task)) {
			task.setProject(this);
			success = true;
		}
		return success;
	}

	public boolean removeTask(Task task) {
		boolean success = false;
		if (tasks.remove(task)) {
			task.setProject(null);
			success = true;
		}
		return success;
	}
	

}
