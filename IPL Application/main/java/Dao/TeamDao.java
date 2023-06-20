package Dao;

import java.util.List;

import pojos.Teams;

public interface TeamDao {
	
	String addTeam(Teams team);
	
	List<Teams> getAllTeams();
	
	Teams getTeamDetails(int id);
}
