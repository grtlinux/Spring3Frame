package dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import dao.EventDao;
import model.Event;

public class EventDaoImpl implements EventDao {

	private EntityManagerFactory emf;

	@PersistenceUnit
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public List<Event> getEventList(Date start, Date end) {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();

		String query = " FROM Event AS event WHERE event.date >= :startDate AND event.date <= :endDate ";
		return em.createQuery(query, Event.class)
				.setParameter("startDate", start)
				.setParameter("endDate", end)
				.getResultList();
	}

}
