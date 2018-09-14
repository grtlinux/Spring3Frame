package dao.impl;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

public class UpdatePlayer extends SqlUpdate {

	private static final String SQL_UPDATE_PLAYER = "update player set name=?, team_id=? where player_id = ?";

	public UpdatePlayer(DataSource ds) {
		super(ds, SQL_UPDATE_PLAYER);
		super.declareParameter(new SqlParameter("name", Types.VARCHAR));
		super.declareParameter(new SqlParameter("team_id", Types.INTEGER));
		super.declareParameter(new SqlParameter("player_id", Types.INTEGER));
		compile();
	}
}
