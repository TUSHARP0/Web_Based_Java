package bean;

import java.util.List;

import Dao.TeamDao;
import Dao.TeamDaoImpl;
import pojos.Teams;

public class IPLBean {
	 private TeamDao dao;
	 
	 public IPLBean() {
		 System.out.println("IPL bean created");
	dao=new TeamDaoImpl();
	}

	public TeamDao getDao() {
		return dao;
	}

	public void setDao(TeamDao dao) {
		this.dao = dao;
	}
	 
	 public List<Teams> fetchAllDetails() {
		 return dao.getAllTeams();
		 
	 }
}
