package tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import cs544.mum.edu.dataaccess.ProjectDAO;
import cs544.mum.edu.models.Project;
import cs544.mum.edu.models.Status;

public class ProjectDaoTest {
	
	private ProjectDAO _projectDao = new ProjectDAO();
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void addProjectTest() throws Exception{
		Project actual = new Project();
		actual.setProjectName("ProjectName1");
		actual.setDescription("This is description about the project");
		actual.setStartDate("12/12/2014");
		actual.setEndDate("12/12/2016");

		actual.setProjectLocation("IOWA");
		actual.setStatus(Status.OPEN);
		_projectDao.AddProject(actual);
		
		List<Project> projects = _projectDao.getAllProjects();
		//returns lastly saved project
		Project expected = projects.get(projects.size()-1);
		
		assertEquals(expected, actual);
		
	}
	@Test
	public void deletProjectTest(){
		
		try {
			
			//Arrange
			Project project = _projectDao.getProjectById(1);
			_projectDao.deleteProject(project);
			
			//Act
			project = _projectDao.getProjectById(1);
			
			//Assert
			assertNull(project);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
