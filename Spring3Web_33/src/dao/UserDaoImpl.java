package dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import logic.User;

public class UserDaoImpl implements UserDao {

	private SimpleJdbcTemplate template;

	public void setDataSource(DataSource dataSource) {
		this.template = new SimpleJdbcTemplate(dataSource);
	}

	@Override
	public User findByUserIdAndPassword(String userId, String password) {
		// TODO Auto-generated method stub
		String query = "SELECT user_id, password, user_name, postcode,"
				+ " address, email, job, birthday "
				+ " FROM user_account "
				+ " WHERE user_id = ? AND password = ?";

		RowMapper<User> mapper = new BeanPropertyRowMapper<User>(User.class);

		return this.template.queryForObject(query, mapper, userId, password);
	}

}
