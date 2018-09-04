package dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import logic.User;

public class UserDaoImpl implements UserDao {

	private SimpleJdbcTemplate template;

	public void setDataSource(DataSource dataSource) {
		this.template = new SimpleJdbcTemplate(dataSource);
	}

	@Override
	public void create(User user) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO user_account "
				+ " (user_id, user_name, password, postcode, address, email, job, birthday)"
				+ " VALUES "
				+ " (:userId, :userName, :password, :postCode, :address, :email, :job, :birthDay)";
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(user);
		this.template.update(query, parameterSource);
	}

}
