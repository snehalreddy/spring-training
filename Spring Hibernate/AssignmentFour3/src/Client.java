import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import org.hibernate.SQLQuery;

import java.util.List;
import java.util.Iterator;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.Session;


public class Client {
	private static SessionFactory factory;

	public static void getSessionFactory() {
		try {
			Configuration conf = new Configuration().configure();
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(conf.getProperties());
			factory=conf.buildSessionFactory(builder.build());
		} catch (Throwable ex) {
			System.err.println("Falied to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static void main(String[] java) {
		try {
			getSessionFactory();
			Client client_1 = new Client();

			CollegeAddress add1 = new CollegeAddress("Flemingo Road", "Washington DC", "USA", "532");
			Student emp1 = new Student(3, "Snehal", "Reddy");
			emp1.setAddress(add1); 
			client_1.insertData(emp1, add1);

			CollegeAddress add2 = new CollegeAddress("Bakers Road", "Detroit", "USA", "555");
			Student emp2 = new Student(4, "Ravi", "Kumar");
			emp2.setAddress(add2);
			client_1.insertData(emp2, add2);

			client_1.DisplayRecords();

		} catch (HibernateException e) {
			System.out.println("Exception is: " + e);
		}
	}

	public void insertData(Student empObj, CollegeAddress addObj) {
		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();
		
		session.save(empObj);
		session.save(addObj);
		tx.commit();
		
		System.out.println("Employee and Address are inserted in the database...");
		session.close();
	}

	public void DisplayRecords() throws HibernateException {
		Session session = factory.openSession();
//		List empLst = session.createQuery("FROM Employee").list();
		Criteria cr = session.createCriteria(Student.class);
		List empLst = cr.list();
		
		for (Iterator iterator = empLst.iterator(); iterator.hasNext();) {
			Student emp = (Student) iterator.next();
			System.out.print("First Name: " + emp.getFirstName());
			System.out.print("Last Name: " + emp.getLastName());
			
			List<CollegeAddress> add = emp.getAddress();
			
			for (Iterator i = add.iterator(); i.hasNext();) {
				CollegeAddress a = (CollegeAddress) i.next();
				System.out.println("College Address: ");
				System.out.println("\tStreet: " + a.getStreet());
				System.out.println("\tCity: " + a.getCity());
				System.out.println("\tState: " + a.getState());
				System.out.println("\tZipcode: " + a.getZipcode());				
			}
			
		}
	
		session.close();
	}


	public void DeleteRecord(int EmployeeID) throws HibernateException {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Student student = (Student) session.get(Student.class, EmployeeID);
		session.delete(student);
		tx.commit();
		session.close();
	}

}

