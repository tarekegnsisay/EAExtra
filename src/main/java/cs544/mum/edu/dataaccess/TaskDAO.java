package cs544.mum.edu.dataaccess;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cs544.mum.edu.models.Task;

public class TaskDAO {
	
	public void addTask(Task task) throws Exception{

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			session.persist(task);
			tx.commit();
			
		}catch (Exception e) {
			if(tx!=null) tx.rollback();
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	/**
	 * This method returns list of tasks for the provided project id
	 * @param status
	 * @return
	 * @throws Exception
	 */
	public List<Task> getTasksByProjectId(int projectId) throws Exception{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		List<Task> tasks = new ArrayList<Task>();
		try{
			tx = session.beginTransaction();
			Query tasktQuery = session.createQuery("FROM Task p WHERE p.project.id = :id");
			tasktQuery.setParameter("id", projectId);
			
			tasks = tasktQuery.list();
			tx.commit();
			
		}catch (Exception e) {
			if(tx!=null) tx.rollback();
			e.printStackTrace();
			throw new Exception(e);
		}
		return tasks;
	}

}
