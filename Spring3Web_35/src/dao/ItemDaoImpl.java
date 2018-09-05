package dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import logic.Item;

@Repository
public class ItemDaoImpl implements ItemDao {

	private SimpleJdbcTemplate template;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.template = new SimpleJdbcTemplate(dataSource);
	}

	@Override
	public List<Item> findAll() {
		// TODO Auto-generated method stub
		String query = "SELECT item_id, item_name, price, description, picture_url FROM item";
		RowMapper<Item> mapper = new BeanPropertyRowMapper<Item>(Item.class);
		return this.template.query(query, mapper);
	}

	@Override
	public Item findByPrimaryKey(Integer itemId) {
		// TODO Auto-generated method stub
		String query = "SELECT item_id, item_name, price, description, picture_url FROM item WHERE item_id = ?";
		RowMapper<Item> mapper = new BeanPropertyRowMapper<Item>(Item.class);
		return this.template.queryForObject(query, mapper, itemId);
	}

}
