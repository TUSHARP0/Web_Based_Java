package pojos;

import java.time.LocalDate;

import javax.persistence.*;
@Entity
@Table(name="players")
public class Players extends BaseEntity{
	@Column(name="first_name",length=30)
	private String firstName;
	@Column(name="last_name",length=30)
	private String lastName;
	
	private LocalDate dob;
	@Column(name="average")
	private double avg;
	
	private int wickets;
	@ManyToOne
	@JoinColumn(name="my_team")
	private Teams myTeam;
	
	public Teams getMyTeam() {
		return myTeam;
	}

	public void setMyTeam(Teams myTeam) {
		this.myTeam = myTeam;
	}

	public Players() {
		// TODO Auto-generated constructor stub
	}

	public Players(String firstName, String lastName, LocalDate dob, double avg, int wickets) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.avg = avg;
		this.wickets = wickets;
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

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public int getWickets() {
		return wickets;
	}

	public void setWickets(int wickets) {
		this.wickets = wickets;
	}

	@Override
	public String toString() {
		return "Players [firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", avg=" + avg
				+ ", wickets=" + wickets + "]";
	}
	
	
}
