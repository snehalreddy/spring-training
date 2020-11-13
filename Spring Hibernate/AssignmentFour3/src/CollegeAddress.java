import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "COLLEGE_ADDRESS")
public class CollegeAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@PrimaryKeyJoinColumn
	private int id;

	@OneToMany(targetEntity = CollegeAddress.class, cascade = CascadeType.ALL)
	private ArrayList<Student> studentsReg = new ArrayList<>();

	private String street;
	private String city; 
	private String state;
	private String zipcode;
	//kya hogaya? Questions gurthulevu XD  One college so Student will be college and phone will be student one college many students okay? Okay
	public ArrayList<Student> getStudentsReg() {
		return studentsReg;
	}

	public void setStudentsReg(Student studentsReg) {
		this.studentsReg.add(studentsReg);
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public CollegeAddress() {
	}

	public CollegeAddress(String street, String city, String state, String zipcode) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipCode(String zipcode) {
		this.zipcode = zipcode;
	}

}
