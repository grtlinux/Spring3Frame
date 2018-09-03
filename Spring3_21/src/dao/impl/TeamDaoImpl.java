package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import dao.TeamDao;
import model.Team;

public class TeamDaoImpl extends JdbcDaoSupport implements TeamDao {

	@Override
	public List<Team> getTeamList() throws DataAccessException {
		// TODO Auto-generated method stub
		RowMapper<Team> rowMapper = new TeamRowMapper();

		return getJdbcTemplate().query("select team_id, name from team", rowMapper);
	}

	protected class TeamRowMapper implements RowMapper<Team> {
		private List<Team> teamList = new ArrayList<>();

		public List<Team> getResults() {
			return this.teamList;
		}

		public Team mapRow(ResultSet rs, int rowNum) throws SQLException {
			Team team = new Team();
			team.setId(rs.getInt("team_id"));
			team.setName(rs.getString("name"));

			return team;
		}
	}
}
