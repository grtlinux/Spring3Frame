package ui;

import java.util.List;

import dao.TicketDao;
import dao.UserDao;
import model.Ticket;
import model.User;

public class SelectUserUi extends AbstractUi {

	private UserDao userDao;
	private TicketDao ticketDao;
	private DeleteReservationUi deleteReservationUi;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setTicketDao(TicketDao ticketDao) {
		this.ticketDao = ticketDao;
	}

	public void setDeleteReservationUi(DeleteReservationUi deleteReservationUi) {
		this.deleteReservationUi = deleteReservationUi;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	protected void showBookedTicketList(List<Ticket> ticketList) {

	}

	protected void showUser(User user) {

	}

	protected void showHeader() {

	}

	protected void showMenu() {

	}
}
