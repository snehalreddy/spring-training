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

			client_1.InsertRecordInDatabase(1, "Rick Grimes", 50);
			client_1.InsertRecordInDatabase(2, "James Bond", 35);
			client_1.InsertRecordInDatabase(3, "Peter Parker", 25);
			client_1.InsertRecordInDatabase(4, "Bruce Banner", 40);

			System.out.println("Listing Employees");
			client_1.DisplayRecords();

			// Deleting
//			client_1.DeleteRecord(1);
//			client_1.DeleteRecord(2);
//			client_1.DeleteRecord(3);
//			client_1.DeleteRecord(4);
//			client_1.DeleteRecord(5);
//			client_1.DeleteRecord(6);
//			client_1.DeleteRecord(7);
//			client_1.DeleteRecord(8);

		} catch (HibernateException e) {
			System.out.println("Exception is: " + e);
		}
	}

	public void InsertRecordInDatabase(int id, String name, int age) throws HibernateException {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		TrainReservation tr = new TrainReservation(id, name, age);
		session.save(tr);
		tx.commit();

		session.close();
	}

	public void DisplayRecords() throws HibernateException {
		Session session = factory.openSession();

		Criteria cr = session.createCriteria(TrainReservation.class);
		cr.add(Restrictions.gt("age", 25));
		cr.add(Restrictions.lt("age", 45));
		
		List empLst = cr.list();

		for (Iterator iterator = empLst.iterator(); iterator.hasNext();) {
			TrainReservation tr = (TrainReservation) iterator.next();

			System.out.println("Name: " + tr.getPassengerName());
			System.out.println("Age: " + tr.getAge());
		}
		session.close();
	}

	public void DeleteRecord(Integer id) throws HibernateException {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		TrainReservation tr = (TrainReservation) session.get(TrainReservation.class, id);
		session.delete(tr);
		tx.commit();
		session.close();
	}

}
