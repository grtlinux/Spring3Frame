package dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Repository;

import logic.Item;

@Repository
public class ItemDaoImpl implements ItemDao {

	@Autowired
	private LobHandler lobHandler;
	private SimpleJdbcTemplate template;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.template = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Item> findAll() {
		// TODO Auto-generated method stub
		String query = "SELECT item_id, item_name, price, description FROM item";
		RowMapper<Item> mapper = new BeanPropertyRowMapper<Item>(Item.class);
		return this.template.query(query, mapper);
	}

	@Override
	public Item findByPrimaryKey(Integer itemId) {
		// TODO Auto-generated method stub
		String query = "SELECT item_id, item_name, price, description FROM item WHERE item_id = ?";
		RowMapper<Item> mapper = new BeanPropertyRowMapper<Item>(Item.class);
		return this.template.queryForObject(query, mapper, itemId);
	}

	@Override
	public List<Item> findByItemName(String itemName) {
		// TODO Auto-generated method stub
		String query = "SELECT item_id, item_name, price, description FROM item WHERE item_name LIKE ?";
		RowMapper<Item> mapper = new BeanPropertyRowMapper<Item>(Item.class);
		return this.template.query(query, mapper, itemName);
	}

	@Override
	public void create(final Item item) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO item(item_name, price, description, picture) values (?, ?, ?, ?)";
		this.jdbcTemplate.execute(query, new AbstractLobCreatingPreparedStatementCallback(lobHandler) {
			@Override
			protected void setValues(PreparedStatement ps, LobCreator lobCreator) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				int index = 0;
				ps.setString(++index, item.getItemName());
				ps.setInt(++index,  item.getPrice().intValue());
				ps.setString(++index, item.getDescription());
				try {
					lobCreator.setBlobAsBytes(ps, ++index, item.getPicture().getBytes());
				} catch (IOException e) {
					// TODO: handle exception
					throw new RuntimeException(e);
				}
			}
		});
	}

	@Override
	public void update(Item item) {
		// TODO Auto-generated method stub
		String query = "UPDATE item SET item_name = ?, price = ?, description = ?, picture = ? WHERE item_id = ?";
		this.jdbcTemplate.execute(query, new AbstractLobCreatingPreparedStatementCallback(lobHandler) {
			@Override
			protected void setValues(PreparedStatement ps, LobCreator lobCreator) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				int index = 0;
				ps.setString(++index, item.getItemName());
				ps.setInt(++index, item.getPrice().intValue());
				ps.setString(++index,  item.getDescription());
				try {
					lobCreator.setBlobAsBytes(ps, ++index, item.getPicture().getBytes());
				} catch (IOException e) {
					// TODO: handle exception
					throw new RuntimeException(e);
				}
			}
		});
	}

	@Override
	public void delete(Item item) {
		// TODO Auto-generated method stub
		this.template.update("DELETE FROM item where item_id = ?",  item.getItemId());
	}

	@Override
	public InputStream getPicture(Integer itemId) {
		// TODO Auto-generated method stub
		return this.template.queryForObject("SELECT picture FROM item WHERE item_id = ?", new RowMapper<InputStream>() {
			@Override
			public InputStream mapRow(ResultSet rs, int i) throws SQLException {
				// TODO Auto-generated method stub
				return lobHandler.getBlobAsBinaryStream(rs, "picture");
			}
		}, itemId);
	}
}
