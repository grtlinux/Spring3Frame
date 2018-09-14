package dao.impl;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

public class DeletePlayer extends SqlUpdate {

	private static final String SQL_DELETE_PLAYER = "delete from player where player_id = ?";

	public DeletePlayer(DataSource ds) {
		super(ds, SQL_DELETE_PLAYER);
		super.declareParameter(new SqlParameter("player_id", Types.INTEGER));
		compile();
	}
}
