import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT_one_to_one")


public class Student{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@PrimaryKeyJoinColumn
	private int id;
	
	private String firstName;
	private String lastName;
	
	@OneToOne(targetEntity=Address.class,cascade=CascadeType.ALL)
	private Address address;
	
	public Student() {}
	
	public Student(int id, String fname,String lname) {
		this.id=id;
		this.firstName=fname;
		this.lastName=lname;
	}
	
	public Student(int id, String fname,String lname,Address address) {
		this.id=id;
		this.firstName=fname;
		this.lastName=lname;
		this.address=address;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String first_name) {
		this.firstName=first_name;
	}
	
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String last_name) {
		this.lastName=last_name;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address=address;
	}
	
	
}