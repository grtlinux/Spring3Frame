package dao;

import java.util.Date;
import java.util.List;

import model.Event;

public interface EventDao {

	public List<Event> getEventList(Date start, Date end);
}
