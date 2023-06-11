package pojo;

import java.sql.Date;

public class Users {
	// id | first_name | last_name | email| password | dob| status | role
	private int Id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Date dob;
	private boolean status;
	private String role;
	
	public Users() {
		super();
	}

	public Users(int id, String firstName, String lastName, String email, String password, Date dob, boolean status,
			String role) {
		super();
		Id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.status = status;
		this.role = role;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Users [Id=" + Id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", dob="
				+ dob + ", status=" + status + ", role=" + role + "]";
	}
	
	
}
