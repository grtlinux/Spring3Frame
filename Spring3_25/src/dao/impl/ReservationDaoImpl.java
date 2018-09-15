package dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import dao.ReservationDao;
import model.Reservation;

public class ReservationDaoImpl implements ReservationDao {

	private EntityManagerFactory emf;

	@PersistenceUnit
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public void cancelReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		reservation = em.merge(reservation);
		em.remove(reservation);

		tx.commit();
	}

	@Override
	public Reservation getReservation(Integer reservationId) {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();

		return em.find(Reservation.class, reservationId);
	}

}
