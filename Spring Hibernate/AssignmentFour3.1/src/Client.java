import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.sql.Insert;

public class Client {
	private static SessionFactory factory;

	public static void getSessionFactory() {
		try {
			Configuration conf = new Configuration().configure();
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
					.applySettings(conf.getProperties());
			factory = conf.buildSessionFactory(builder.build());
		} catch (Throwable ex) {
			System.err.println("Falied to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static void main(String[] args) {
		getSessionFactory();

		Session session = factory.openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();

			ArrayList<Student> students = new ArrayList<>();
			students.add(new Student(1, "John", "Doe", "MGMT"));
			students.add(new Student(3, "Jane", "Doe", "HR"));
			College college = new College(1, "MIT", "MIT_ADDRESS", students);
			session.save(college);
			transaction.commit();

			DisplayRecords();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public static void DisplayRecords() throws HibernateException {
		Session session = factory.openSession();
		Criteria cr = session.createCriteria(College.class);
		List empLst = cr.list();

		for (Iterator iterator = empLst.iterator(); iterator.hasNext();) {
			College emp = (College) iterator.next();
			System.out.print("First Name: " + emp.getName());
			System.out.print("Last Name: " + emp.getAddress());

			List<Student> add = emp.getStudents();

			for (Iterator i = add.iterator(); i.hasNext();) {
				Student a = (Student) i.next();

				System.out.println("Student details: ");
				System.out.println("First name: " + a.getFname());
				System.out.println("Last name: " + a.getLname());
				System.out.println("Course: " + a.getCourse());
			}

		}

		session.close();
	}
}
