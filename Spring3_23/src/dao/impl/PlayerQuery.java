package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

import model.Player;
import model.Team;

public class PlayerQuery extends MappingSqlQuery<Player> {

	private static final String SQL_PLAYER_QUERY = ""
			+ " select"
			+ "     player_id,"
			+ "     player.name as playerName,"
			+ "     team.team_id, "
			+ "     team.name as teamName"
			+ " from"
			+ "     player,"
			+ "     team"
			+ " where 1=1"
			+ "     and player.team_id = team.team_id"
			+ "     and team.team_id = ?";

	public PlayerQuery(DataSource ds) {
		super(ds, SQL_PLAYER_QUERY);
		super.declareParameter(new SqlParameter("player_id", Types.INTEGER));
		compile();
	}

	@Override
	protected Player mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Player player = new Player();
		player.setId(rs.getInt("player_id"));
		player.setName(rs.getString("playerName"));
		Team team = new Team();
		team.setId(rs.getInt("team_id"));
		team.setName(rs.getString("teamName"));
		player.setTeam(team);

		return player;
	}

}
