package dao;

import model.Reservation;

public interface ReservationDao {

	public void cancelReservation(Reservation reservation);
	public Reservation getReservation(Integer reservationId);
}
