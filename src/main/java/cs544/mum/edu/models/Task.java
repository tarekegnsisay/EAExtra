package cs544.mum.edu.models;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.persistence.*;

@Entity
public class Task {
	
	@Id @GeneratedValue
	private int id;
	
	private String taskName;
	
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	private String neededResources;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
/*	@JoinColumn(name="project_Id")*/
	private Project project;
	@OneToOne(mappedBy="task")
	private Volunteer volunter;
	
	private static DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT,
			Locale.US);
    
	public Task(){
		
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
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

	public String getNeededResources() {
		return neededResources;
	}

	public void setNeededResources(String neededResources) {
		this.neededResources = neededResources;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public Volunteer getVolunter() {
		return volunter;
	}
	public void setVolunter(Volunteer volunter) {
		this.volunter = volunter;
		volunter.setTask(this);
	}
	
	
		

}
