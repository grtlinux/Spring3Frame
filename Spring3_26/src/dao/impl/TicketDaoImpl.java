package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dao.TicketDao;
import model.Ticket;

public class TicketDaoImpl implements TicketDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Ticket> getBookedTicketList(Integer userId) {
		// TODO Auto-generated method stub
		String query = " FROM Ticket AS ticket INNER JOIN FETCH ticket.event AS event "
				+ " INNER JOIN FETCH ticket.rank AS rank WHERE ticket.reservation.user.userId = :userId ";

		return em.createQuery(query, Ticket.class)
				.setParameter("userId", userId)
				.getResultList();
	}

	@Override
	public List<Ticket> getNotBookedTicketList(Integer rankId, Integer quantity) {
		// TODO Auto-generated method stub
		String query = " FROM Ticket AS ticket LEFT OUTER JOIN FETCH ticket.reservation reservation "
				+ " WHERE ticket.rank.rankId = :rankId AND reservation IS NULL ";

		return em.createQuery(query, Ticket.class)
				.setParameter("rankId", rankId)
				.setMaxResults(quantity)
				.getResultList();
	}

}
