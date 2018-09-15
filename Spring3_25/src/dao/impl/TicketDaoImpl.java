package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import dao.TicketDao;
import model.Ticket;

public class TicketDaoImpl implements TicketDao {

	private EntityManagerFactory emf;

	@PersistenceUnit
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public List<Ticket> getBookedTicketList(Integer userId) {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();

		String query = " FROM Ticket AS ticket INNER JOIN FETCH ticket.event AS event "
				+ " INNER JOIN FETCH ticket.rank AS rank WHERE ticket.reservation.user.userId = :userId ";

		return em.createQuery(query, Ticket.class)
				.setParameter("userId", userId)
				.getResultList();
	}

}
