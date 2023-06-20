package bean;

import java.time.LocalDate;

import Dao.PlayerDao;
import Dao.PlayerDaoImpl;
import Dao.TeamDao;
import Dao.TeamDaoImpl;
import pojos.Players;
import pojos.Teams;

public class PlayerBean {
	
	private static TeamDao team;
	private static PlayerDao player;
	private Players p;
	
//	myTeam=1&fn=Tushar&fn=Pawar&dob=2023-06-14&avg=50.00&wickets=50
	
	private String myTeam;
	private String fn;
	private String ln;
	private String dob;
	private String avg;
	private String wickets;
	
	public PlayerBean() {
		team=new TeamDaoImpl();
		player= new PlayerDaoImpl();
	}

	public static TeamDao getTeam() {
		return team;
	}

	public static void setTeam(TeamDao team) {
		PlayerBean.team = team;
	}

	public static PlayerDao getPlayer() {
		return player;
	}

	public static void setPlayer(PlayerDao player) {
		PlayerBean.player = player;
	}

	public Players getP() {
		return p;
	}

	public void setP(Players p) {
		this.p = p;
	}

	public String getMyTeam() {
		return myTeam;
	}

	public void setMyTeam(String myTeam) {
		this.myTeam = myTeam;
	}

	public String getFn() {
		return fn;
	}

	public void setFn(String fn) {
		this.fn = fn;
	}

	public String getLn() {
		return ln;
	}

	public void setLn(String ln) {
		this.ln = ln;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAvg() {
		return avg;
	}

	public void setAvg(String avg) {
		this.avg = avg;
	}

	public String getWickets() {
		return wickets;
	}

	public void setWickets(String wickets) {
		this.wickets = wickets;
	}
	
	public String validateAndAddPlayer() {
		String msg="Insertion Failed";
		int teamID = Integer.parseInt(myTeam);
		Teams teamDetails = team.getTeamDetails(teamID);
		LocalDate date=LocalDate.parse(dob);
		double battingAvg= Double.parseDouble(avg);
		int wicketsTaken=Integer.parseInt(wickets);
		if(LocalDate.now().getYear()-date.getYear() < teamDetails.getMaxAge() && 
			battingAvg > teamDetails.getMinAvg() && wicketsTaken > teamDetails.getMinWickets() ) 
		{
			//String firstName, String lastName, LocalDate dob, double avg, int wickets
			p= new Players(fn,ln,date,battingAvg,wicketsTaken);
			player.addPlayer(p,teamID);
			msg="Player Insertion Successful";
		}
		
		
		return msg;
	}
}
