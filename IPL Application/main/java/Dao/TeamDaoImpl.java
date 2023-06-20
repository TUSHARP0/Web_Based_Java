package Dao;

import static utils.HibernateUtils.getFactory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Teams;

public class TeamDaoImpl implements TeamDao {

	@Override
	public String addTeam(Teams team) {
		String msg="Insertion Failed";
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			session.persist(team);
			tx.commit();
			msg="Insertion Successful";
		}catch(RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return msg;
	}

	@Override
	public List<Teams> getAllTeams() {
		List<Teams> team=null;
		String jpql="select new pojos.Teams(id,abb) from Teams";
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			team=session.createQuery(jpql,Teams.class).getResultList();
			tx.commit();
		}catch(RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return team;
	}

	@Override
	public Teams getTeamDetails(int id) {
		Teams team=null;
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			team=session.get(Teams.class, id);
			tx.commit();
		}catch(RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return team;
	}

}
