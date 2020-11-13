import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
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
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
					.applySettings(conf.getProperties());
			factory = conf.buildSessionFactory(builder.build());
		} catch (Throwable ex) {
			System.err.println("Falied to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static void main(String[] java) {
		try {
			getSessionFactory();
			Client client_1 = new Client();

//			client_1.InsertRecordInDatabase(2, "Amy", "N", 5000);
//			client_1.InsertRecordInDatabase(3, "Alice", "B", 5000);
//			client_1.InsertRecordInDatabase(4, "Alex", "D", 5000);
//			client_1.InsertRecordInDatabase(5, "Alan", "P", 5000);
//			client_1.InsertRecordInDatabase(6, "Rahtoken", "A", 5000);
//			client_1.InsertRecordInDatabase(7, "Lisa", "K", 5000);
//			client_1.InsertRecordInDatabase(8, "Lucy", "N", 5000);

			System.out.println("Listing Employees");
			client_1.DisplayRecords();

			// Deleting
			client_1.DeleteRecord(1);
			client_1.DeleteRecord(2);
			client_1.DeleteRecord(3);
			client_1.DeleteRecord(4);
			client_1.DeleteRecord(5);
			client_1.DeleteRecord(6);
			client_1.DeleteRecord(7);
			client_1.DeleteRecord(8);

		} catch (HibernateException e) {
			System.out.println("Exception is: " + e);
		}
	}

	public void InsertRecordInDatabase(int id, String fname, String lname, int salary) throws HibernateException {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Employee el = new Employee(id, fname, lname, salary);
		session.save(el);
		tx.commit();

		session.close();
	}

	public void DisplayRecords() throws HibernateException {
		Session session = factory.openSession();

//		List empLst = session.createQuery("FROM Employee").list();
		Criteria cr = session.createCriteria(Employee.class);
//		cr.add(Restrictions.gt("salary", 5000));
		List empLst = cr.list();

		for (Iterator iterator = empLst.iterator(); iterator.hasNext();) {
			Employee emp = (Employee) iterator.next();
			System.out.print("First Name: " + emp.getFirstName());
			System.out.print("   Last Name: " + emp.getLastName());
			System.out.println("    Salary : " + emp.getSalary());

		}
		session.close();
	}

	public void UpdateRecord(Integer EmpId, int salary) throws HibernateException {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Employee employee = (Employee) session.get(Employee.class, EmpId);
		employee.setSalary(salary);
		session.saveOrUpdate(employee);
		tx.commit();
		session.close();
	}

	public void DeleteRecord(Integer EmployeeID) throws HibernateException {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Employee employee = (Employee) session.get(Employee.class, EmployeeID);
		session.delete(employee);
		tx.commit();
		session.close();
	}

}
