package dao;

import java.util.List;

import model.Ticket;

public interface TicketDao {

	public List<Ticket> getBookedTicketList(Integer userId);
}
