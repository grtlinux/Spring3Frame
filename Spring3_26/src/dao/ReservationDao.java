package dao;

import model.Reservation;

public interface ReservationDao {

	public void addReservation(Reservation reservation);
	public void cancelReservation(Reservation reservation);
	public Reservation getReservation(Integer reserationId);
}
