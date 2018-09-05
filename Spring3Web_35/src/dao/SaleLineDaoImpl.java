package dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import logic.SaleLine;

@Repository
public class SaleLineDaoImpl implements SaleLineDao {

	private SimpleJdbcTemplate template;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.template = new SimpleJdbcTemplate(dataSource);
	}

	@Override
	public void create(SaleLine saleLine) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO sale_line(sale_id, sale_line_id, item_id, quantity, update_time)"
				+ " VALUES(?, ?, ?, ?, ?)";
		this.template.update(query,
				saleLine.getSale().getSaleId(),
				saleLine.getSaleLineId(),
				saleLine.getItem().getItemId(),
				saleLine.getQuantity(),
				saleLine.getUpdateTime());
	}

}
