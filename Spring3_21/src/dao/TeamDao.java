package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import model.Team;

public interface TeamDao {

	public List<Team> getTeamList() throws DataAccessException;
}
