package TestSP;

import static org.testng.Assert.assertEquals;

import org.junit.Test;

import com.poly.dao.ProductDao;
import com.poly.model.Product;

public class TestUpdateSP {
	@Test
	public void UpdateSp() throws Exception{
	    ProductDao proDao = new ProductDao();
	    Product pro = proDao.findById(3);
		pro.setName("SP3_NewTest");
		proDao.updatePro(pro);
		 Product uppro = proDao.findById(3);
		 assertEquals(uppro.getName(), "SP3_NewTest");

	}
}
