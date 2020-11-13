import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "STUDENT")
public class Student implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@PrimaryKeyJoinColumn(name = "STD_ID")
	private int id;

	private String fname;
	private String lname;

	@Column( length = 100000 )
	private ArrayList<Teacher> teachers = new ArrayList<Teacher>();

	public Student() {
	}

	public Student(int id, String fname, String lname) {
		this.id = id;
		this.fname = fname;
		this.lname = lname;
	}

	public Student(int id, String fname, String lname, ArrayList<Teacher> teachers) {
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.teachers = teachers;
	}

	public ArrayList<Teacher> getTeachers() {
		return teachers;
	}

	@ManyToMany(targetEntity = Teacher.class, cascade = { CascadeType.ALL })
	public void setTeachers(ArrayList<Teacher> teachers) {
		this.teachers = teachers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

}
