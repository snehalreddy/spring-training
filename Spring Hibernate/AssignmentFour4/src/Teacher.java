import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "TEACHER")
public class Teacher implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@PrimaryKeyJoinColumn(name = "TCH_ID")
	private int id;

	private String fname;
	private String lname;

	@Column( length = 100000 ) 
	private ArrayList<Student> students = new ArrayList<>();

	public Teacher() {
	}

	public Teacher(int id, String fname, String lname) {
		this.id = id;
		this.fname = fname;
		this.lname = lname;
	}

	public Teacher(int id, String fname, String lname, ArrayList<Student> students) {
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.students = students;
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

	public ArrayList<Student> getStudents() {
		return students;
	}

	@ManyToMany(targetEntity = Student.class, cascade = { CascadeType.ALL })
	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}
}
