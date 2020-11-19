package TestSP;

import static org.testng.Assert.assertEquals;

import org.junit.Test;
import com.poly.dao.ProductDao;
import com.poly.model.Product;

public class TestDeleteSP {
	@Test
	public void UpdateUser() {
	    ProductDao proDao = new ProductDao();
	    Product pro = proDao.findById(3);
		assertEquals(pro.getId(),3);
		proDao.deletePro(3);
	}
}

