package cs544.mum.edu.dataaccess;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cs544.mum.edu.models.Volunteer;

public class VolunteerDAO {

public void AddVolunteer(Volunteer volunteer) throws Exception{
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			session.persist(volunteer);
			tx.commit();
			
		}catch (Exception e) {
			if(tx!=null) tx.rollback();
			e.printStackTrace();
			throw new Exception(e);
		}
		
	}
}
