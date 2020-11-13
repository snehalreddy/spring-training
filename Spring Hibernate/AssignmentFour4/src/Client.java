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
			ArrayList<Teacher> teachers = new ArrayList<>();

			Student stu1 = new Student(1, "John", "Doe", teachers);
			Student stu2 = new Student(2, "Jane", "Doe", teachers);
			students.add(stu1);
			students.add(stu2);

			Teacher tch1 = new Teacher(1, "Sir", "Doe", students);
			Teacher tch2 = new Teacher(2, "Madam", "Doe", students);
			teachers.add(tch1);
			teachers.add(tch2);

			session.save(tch1);
			session.save(tch2);

			session.save(stu1);
			session.save(stu2);
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

		System.out.println("Teachers to Students");

		Criteria cr = session.createCriteria(Teacher.class);
		List empLst = cr.list();

		for (Iterator iterator = empLst.iterator(); iterator.hasNext();) {
			Teacher emp = (Teacher) iterator.next();
			System.out.println("Teacher details: ");
			System.out.print("First Name: " + emp.getFname() + " ");
			System.out.print("Last Name: " + emp.getLname());
			System.out.println();
			System.out.println();

			ArrayList<Student> add = emp.getStudents();
			for (Iterator i = add.iterator(); i.hasNext();) {
				Student a = (Student) i.next();
				System.out.println("Student details: ");
				System.out.println("First name: " + a.getFname() + " ");
				System.out.println("Last name: " + a.getLname());
				System.out.println();
			}

			System.out.println();
		}

		System.out.println("========================================");
		System.out.println();

		System.out.println("Student to Teachers");
		cr = session.createCriteria(Student.class);
		empLst = cr.list();

		for (Iterator iterator = empLst.iterator(); iterator.hasNext();) {
			Student emp = (Student) iterator.next();
			System.out.println("Student details: ");
			System.out.print("First Name: " + emp.getFname() + " ");
			System.out.print("Last Name: " + emp.getLname());
			System.out.println();
			System.out.println();

			ArrayList<Teacher> add = emp.getTeachers();
			for (Iterator i = add.iterator(); i.hasNext();) {
				Teacher a = (Teacher) i.next();
				System.out.println("Teacher details: ");
				System.out.println("First name: " + a.getFname() + " ");
				System.out.println("Last name: " + a.getLname());
				System.out.println();
			}

			System.out.println();
		}
		System.out.println("========================================");
		session.close();
	}
}
