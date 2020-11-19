package TestSP;

import static org.testng.Assert.assertEquals;

import org.junit.Test;

import com.poly.dao.ProductDao;
import com.poly.model.Product;

public class TestAddSPFail {
	@Test
	public void addSp() throws Exception{
	    ProductDao proDao = new ProductDao();
	    Product pro = new Product();
		pro.setName("SP2_Test");
	    pro.setPrice(120000000);
	    pro.setNote("");
	    pro.setImage("6.png");
	    pro.setCategory_id(1);
	    proDao.insertPro(pro);
		Product newPro = proDao.findById(4);
		assertEquals(newPro.getName(), "SP2_Test");
	}
}
