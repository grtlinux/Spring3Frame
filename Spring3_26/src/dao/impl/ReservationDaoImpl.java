package dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dao.ReservationDao;
import model.Reservation;

public class ReservationDaoImpl implements ReservationDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void addReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		em.persist(reservation);
	}

	@Override
	public void cancelReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		reservation = em.merge(reservation);
		em.remove(reservation);
	}

	@Override
	public Reservation getReservation(Integer reservationId) {
		// TODO Auto-generated method stub
		return em.find(Reservation.class, reservationId);
	}

}
