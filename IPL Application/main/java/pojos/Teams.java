package pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="teams")
public class Teams extends BaseEntity{
	@Column(name="team_name",length=30)
	private String name;
	@Column(name="abbrevation",length=30)
	private String abb;
	@Column(length=30)
	private String owner;
	@Column(name="max_age")
	private int maxAge;
	@Column(name="min_average")
	private double minAvg;
	@Column(name="min_wickets")
	private int minWickets;
	
	@OneToMany(mappedBy="myTeam",cascade=CascadeType.ALL,orphanRemoval = true)
	private List<Players> players= new ArrayList<>();
	
	public List<Players> getPlayers() {
		return players;
	}

	public void setPlayers(List<Players> players) {
		this.players = players;
	}

	public Teams() {
		// TODO Auto-generated constructor stub
	}
	
	public Teams(int id, String abb) {
		super.setId(id);
		this.abb=abb;
	}

	public Teams(String name, String abb, String owner, int maxAge, double minAvg, int minWickets) {
		super();
		this.name = name;
		this.abb = abb;
		this.owner = owner;
		this.maxAge = maxAge;
		this.minAvg = minAvg;
		this.minWickets = minWickets;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbb() {
		return abb;
	}

	public void setAbb(String abb) {
		this.abb = abb;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}

	public double getMinAvg() {
		return minAvg;
	}

	public void setMinAvg(double minAvg) {
		this.minAvg = minAvg;
	}

	public int getMinWickets() {
		return minWickets;
	}

	public void setMinWickets(int minWickets) {
		this.minWickets = minWickets;
	}
	
	public void addplayer(Players p) {
		players.add(p);
		p.setMyTeam(this);
	}
	
	public void removePlayer(Players p) {
		players.remove(p);
		p.setMyTeam(null);
	}
	@Override
	public String toString() {
		return "Teams [name=" + name + ", abb=" + abb + ", owner=" + owner + ", maxAge=" + maxAge + ", minAvg=" + minAvg
				+ ", minWickets=" + minWickets + "]";
	}
	
	
}
