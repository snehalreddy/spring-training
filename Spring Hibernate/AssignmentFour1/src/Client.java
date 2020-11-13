import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import org.hibernate.SQLQuery;

import java.util.List;
import java.util.Iterator;

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

			client_1.InsertRecordInDatabase(1, 111, "Rick", 8000);
			client_1.InsertRecordInDatabase(2, 112, "Brick", 8000);
//			client_1.InsertRecordInDatabase(3, "Alice", "B", 5000);
//			client_1.InsertRecordInDatabase(4, "Alex", "D", 5000);
//			client_1.InsertRecordInDatabase(5, "Alan", "P", 5000);
//			client_1.InsertRecordInDatabase(6, "Rahtoken", "A", 5000);
//			client_1.InsertRecordInDatabase(7, "Lisa", "K", 5000);
//			client_1.InsertRecordInDatabase(8, "Lucy", "N", 5000);
			
			
			// Deleting
//			 System.out.println("Deleting record with id 2");
//			client_1.DeleteRecord(1);
//			client_1.DeleteRecord(2);
//			client_1.DeleteRecord(3);
//			client_1.DeleteRecord(4);
//			client_1.DeleteRecord(5);
//			client_1.DeleteRecord(6);
//			client_1.DeleteRecord(7);
//			 client_1.DeleteRecord(8);

//			Updating
//			client_1.UpdateRecord(1, 10000);

			System.out.println("Listing Employees");
			client_1.DisplayRecords();

		} catch (HibernateException e) {
			System.out.println("Exception is: " + e);
		}
	}

	public void InsertRecordInDatabase(int id, int policyNo, String name, int amount) throws HibernateException {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Insurance el = new Insurance(id, policyNo, name, amount);
		session.save(el);
		tx.commit();

		session.close();
	}

	public void DisplayRecords() throws HibernateException {
		Session session = factory.openSession();
		List empLst = session.createQuery("FROM Insurance").list(); 
		for (Iterator iterator = empLst.iterator(); iterator.hasNext();) {
			Insurance emp = (Insurance) iterator.next();
			System.out.println("Policy number: " + emp.getPolicyNo());
			System.out.println("Name: " + emp.getName());
			System.out.println("Amount: " + emp.getAmount());
		}
		session.close();
	}

	public void UpdateRecord(Integer EmpId, int amount) throws HibernateException {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Insurance employee = (Insurance) session.get(Insurance.class, EmpId);
		employee.setAmount(amount);
		session.saveOrUpdate(employee);
		tx.commit();
		session.close();
	}

	public void DeleteRecord(int EmployeeID) throws HibernateException {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Insurance employee = (Insurance) session.get(Insurance.class, EmployeeID);
		session.delete(employee);
		tx.commit();
		session.close();
	}

}
