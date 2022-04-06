package myproject.employee.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import myproject.employee.pojo.Employee;

public class Test {

	public static void main(String[] args) {
		Configuration config = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
		config = new Configuration();
		config.configure();
		sessionFactory = config.buildSessionFactory();
		session = sessionFactory.openSession();
		tx = session.getTransaction();
		tx.begin();
		Employee emp = new Employee();
		emp.setEno(8);
		emp.setEname("Gibbs");
		emp.setEsal(5784.45f);
		emp.setEaddr("Navlakha,Indore");
//		session.update(emp);
		session.saveOrUpdate(emp);
		tx.commit();
		System.out.print("Employee Updated Successfully");
		}catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			System.out.println("Employee Updation Failure");
		}finally {
			session.close();
			sessionFactory.close();
		}
	}
}
