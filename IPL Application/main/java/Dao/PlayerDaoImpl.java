package Dao;

import static utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Players;
import pojos.Teams;

public class PlayerDaoImpl implements PlayerDao{

	@Override
	public String addPlayer(Players player, int id) {
		String msg="Insertion Failed";
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			Teams t=session.get(Teams.class,id);
			if(t!=null) {
				t.addplayer(player);
				msg="Insertion Successful";
			}
			tx.commit();
			
		}catch(RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return msg;
	}
	
}
