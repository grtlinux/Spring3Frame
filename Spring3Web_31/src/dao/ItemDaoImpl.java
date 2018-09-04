package dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import logic.Item;

public class ItemDaoImpl implements ItemDao {

	private SimpleJdbcTemplate template;

	public void setDataSource(DataSource dataSource) {
		this.template = new SimpleJdbcTemplate(dataSource);
	}

	private static final String SELECT_ALL = "select item_id, item_name, price, description, picture_url from item";

	@Override
	public List<Item> findAll() {
		// TODO Auto-generated method stub
		RowMapper<Item> mapper = new BeanPropertyRowMapper<Item>(Item.class);
		return this.template.query(ItemDaoImpl.SELECT_ALL, mapper);
	}

}
