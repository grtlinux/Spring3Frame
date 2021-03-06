package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.SaleDao;
import dao.SaleLineDao;

@Service
public class SaleCatalogImpl implements SaleCatalog {

	@Autowired
	private SaleDao saleDao;

	@Autowired
	private SaleLineDao saleLineDao;

	@Override
	public void entrySale(Sale sale) {
		// TODO Auto-generated method stub
		this.saleDao.create(sale);

		List<SaleLine> saleLineList = sale.getSaleLineList();
		for (SaleLine saleLine : saleLineList) {
			this.saleLineDao.create(saleLine);
		}
	}

	@Override
	public Integer getNewSaleId() {
		// TODO Auto-generated method stub
		int newSaleId = this.saleDao.findMaxSaleId().intValue() + 1;
		return new Integer(newSaleId);
	}

}
