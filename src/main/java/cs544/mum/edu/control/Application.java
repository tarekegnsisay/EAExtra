package cs544.mum.edu.control;

import java.util.List;

import cs544.mum.edu.dataaccess.ProjectDAO;
import cs544.mum.edu.dataaccess.TaskDAO;
import cs544.mum.edu.dataaccess.VolunteerDAO;
import cs544.mum.edu.models.Project;
import cs544.mum.edu.models.Status;
import cs544.mum.edu.models.Task;
import cs544.mum.edu.models.UserRole;
import cs544.mum.edu.models.Volunteer;

public class Application {

	public static void main(String[] args) throws Exception {
		//addProject();
		ProjectDAO _projectDao = new ProjectDAO();

		Project project = _projectDao.getProjectById(1);

		addTask(project);
		//populateProjects();*/

	}

	public static void populateProjects() {
		ProjectDAO _projectDao = new ProjectDAO();
		try {
			List<Project> projects = _projectDao.getAllProjects();
			for (Project project : projects) {
				System.out.println("Project Name" + project.getProjectName());
				for(Task task :project.getTasks()){
					System.out.println("Task Name" + task.getTaskName());
				}
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void addTask(Project project) {
		TaskDAO _TaskDAO = new TaskDAO();
		/**
		 * Sample Task 1
		 */
		Task task = new Task();
		task.setTaskName("Task1");
		task.setStartDate("11/10/2015");
		task.setEndDate("10/10/2016");
		task.setNeededResources("List of needed Resources");
		task.setStatus(Status.TODO);
		project.addTask(task);

		try {
			_TaskDAO.addTask(task);
			System.out.println("Task Added");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void addVolunteer() {
		VolunteerDAO _vVolunteerDAO = new VolunteerDAO();
		Volunteer volunteer = new Volunteer();
		volunteer.setFirstName("Fisseha");
		volunteer.setLastName("Chari");
		volunteer.setDescription("this is volunteer description");
		volunteer.setUserRole(UserRole.VOLUNTEER);
		try {
			_vVolunteerDAO.AddVolunteer(volunteer);
			System.out.println("Volunteer Added");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public static void addProject() {
		ProjectDAO _projectDao = new ProjectDAO();
		Project project = new Project();
		project.setProjectName("ProjectName1");
		project.setDescription("This is description about the project");
		project.setStartDate("12/12/2014");
		project.setEndDate("12/12/2016");

		project.setProjectLocation("IOWA");
		project.setStatus(Status.OPEN);

		try {
			_projectDao.AddProject(project);
			System.out.println("Project Added");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
