package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import dao.TeamDao;
import model.Team;

public class TeamDaoImpl extends NamedParameterJdbcDaoSupport implements TeamDao {

	@Override
	public List<Team> getTeamList() throws DataAccessException {
		// TODO Auto-generated method stub
		return getJdbcTemplate().query("select team_id as id, name from team"
				, BeanPropertyRowMapper.newInstance(Team.class));
	}

	@Override
	public Team getTeam(Integer teamId) throws DataAccessException {
		// TODO Auto-generated method stub
		final String sql = "select team_id, name from team where team_id = :teamId";
		SqlParameterSource parameterSource = new MapSqlParameterSource("teamId", teamId);
		return getNamedParameterJdbcTemplate().query(sql, parameterSource, new TeamResultSetExtractor());
	}

	protected class TeamResultSetExtractor implements ResultSetExtractor<Team> {

		@Override
		public Team extractData(ResultSet rs) throws SQLException, DataAccessException {
			// TODO Auto-generated method stub
			if (rs.next()) {
				Team team = new Team();
				team.setId(rs.getInt("team_id"));
				team.setName(rs.getString("name"));
				return team;
			} else {
				return null;
			}
		}
	}
}
