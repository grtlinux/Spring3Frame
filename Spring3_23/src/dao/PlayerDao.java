package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import model.Player;

public interface PlayerDao {

	public void insertPlayer(Player player) throws DataAccessException;
	public List<Player> getPlayerList(Integer teamId) throws DataAccessException;
	public void deletePlayer(Player player) throws DataAccessException;
	public void updatePlayer(Player player) throws DataAccessException;
	public Player getPlayer(Integer id) throws DataAccessException;
}
