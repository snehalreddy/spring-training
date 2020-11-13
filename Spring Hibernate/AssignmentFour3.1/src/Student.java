import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class Student implements Serializable {
	@Id
	@GeneratedValue
	@PrimaryKeyJoinColumn(name = "STD_ID")
	private int id;

	private String fname;
	private String lname;
	private String course;

	public Student() {
	}

	public Student(int id, String fname, String lname, String course) {
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.course = course;
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

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

}
