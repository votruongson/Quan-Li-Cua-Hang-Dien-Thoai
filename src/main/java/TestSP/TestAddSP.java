package TestSP;

import static org.testng.Assert.assertEquals;

import org.junit.Test;

import com.poly.dao.ProductDao;
import com.poly.model.Product;

public class TestAddSP {
	@Test
	public void addSp() throws Exception{
	    ProductDao proDao = new ProductDao();
	    Product pro = new Product();
		pro.setName("SP1_Test");
	    pro.setPrice(120000000);
	    pro.setNote("High Quaility");
	    pro.setImage("5.png");
	    pro.setCategory_id(1);
	    proDao.insertPro(pro);
		Product newPro = proDao.findById(3);
		assertEquals(newPro.getName(), "SP1_Test");
	}
}
