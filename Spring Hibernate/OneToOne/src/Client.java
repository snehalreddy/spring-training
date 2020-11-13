autoimport org.hibernate.SessionFactory;
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

			Address add1 = new Address("Flemingo Road", "Washington DC", "USA", "532");
			Employee emp1 = new Employee(3, "Snehal", "Reddy", 8000);
			emp1.getAddress();
			client_1.insertData(emp1, add1);
			Address add2 = new Address("Bakers Road", "Detroit", "USA", "555");
			Employee emp2 = new Employee(4, "Ravi", "Kumar", 3000);
			emp2.getAddress();
			client_1.insertData(emp2, add2);

			client_1.DisplayRecords();

		} catch (HibernateException e) {
			System.out.println("Exception is: " + e);
		}
	}

	public void insertData(Employee empObj, Address addObj) {
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
		Criteria cr = session.createCriteria(Employee.class);
		List empLst = cr.list();
		
		for (Iterator iterator = empLst.iterator(); iterator.hasNext();) {
			Employee emp = (Employee) iterator.next();
			System.out.print("First Name: " + emp.getFirstName());
			System.out.print("Last Name: " + emp.getLastName());
			System.out.println("Salary : " + emp.getSalary());
			Address add = emp.getAddress();
			System.out.println("Address: ");
			System.out.println("\tStreet: " + add.getStreet());
			System.out.println("\tCity: " + add.getCity());
			System.out.println("\tState: " + add.getState());
			System.out.println("\tZipcode: " + add.getZipcode());
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

	public void DeleteRecord(int EmployeeID) throws HibernateException {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Employee employee = (Employee) session.get(Employee.class, EmployeeID);
		session.delete(employee);
		tx.commit();
		session.close();
	}

}

