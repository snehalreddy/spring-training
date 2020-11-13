import java.util.ArrayList;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "COLLEGE")
public class College {
	@Id
	@GeneratedValue
	@PrimaryKeyJoinColumn(name = "COLL_ID")
	private int id;
	
	private String name;
	private String address;

	private ArrayList<Student> students = new ArrayList<Student>();

	public College() {
	}

	public College(int id, String name, String address, ArrayList<Student> student) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.students = student;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public ArrayList<Student> getStudents() {
		return students;
	}

	
	@OneToMany(targetEntity = Student.class, cascade = { CascadeType.ALL })
	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

}
