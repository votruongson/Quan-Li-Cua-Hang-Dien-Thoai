package Test;

import static org.testng.Assert.assertEquals;

import org.junit.Test;

import com.poly.dao.UserDao;
import com.poly.model.User;

public class TestUpdateUser {
	@Test
	public void UpdateUser() {
		UserDao use = new UserDao();
		User user = use.findById(4);
		user.setPassword("123");
		use.updateUser(user);
		User update = use.findById(4);
		assertEquals(update.getPassword(),"123");
	
	}
}
