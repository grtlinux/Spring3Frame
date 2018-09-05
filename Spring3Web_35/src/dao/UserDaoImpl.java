package dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import logic.User;

@Repository
public class UserDaoImpl implements UserDao {

	private SimpleJdbcTemplate template;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.template = new SimpleJdbcTemplate(dataSource);
	}

	@Override
	public void create(User user) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO user_account "
				+ " (user_id, user_name, password, postcode, address, email, job, birthday)"
				+ " VALUES"
				+ "(:userId, :userName, :password, :postCode, :address, :email, :job, :birthDay)";
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(user);
		this.template.update(query, parameterSource);
	}

	@Override
	public User findByUserIdAndPassword(String userId, String password) {
		// TODO Auto-generated method stub
		String query = "SELECT user_id, password, user_name, postcode, address, email, job, birthday"
				+ " FROM user_account"
				+ " WHERE user_id = ? AND password = ?";
		RowMapper<User> mapper = new BeanPropertyRowMapper<User>(User.class);
		return this.template.queryForObject(query, mapper, userId, password);
	}

}
