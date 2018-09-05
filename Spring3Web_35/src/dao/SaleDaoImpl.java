package dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import logic.Sale;

public class SaleDaoImpl implements SaleDao {

	private SimpleJdbcTemplate template;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.template = new SimpleJdbcTemplate(dataSource);
	}

	@Override
	public void create(Sale sale) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO sale(sale_id, user_id, update_time) VALUES(?, ?, ?)";
		this.template.update(query, sale.getSaleId(), sale.getUser().getUserId(), sale.getUpdateTime());
	}

	@Override
	public Integer findMaxSaleId() {
		// TODO Auto-generated method stub
		String query = "SELECT MAX(sale_id) AS sale_id FROM sale";
		return this.template.queryForInt(query);
	}

}
