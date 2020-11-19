package Test;

import static org.testng.Assert.assertEquals;

import org.junit.Test;

import com.poly.dao.UserDao;
import com.poly.model.User;

public class TestDeleteUser {
	@Test
	public void UpdateUser() {
		UserDao use = new UserDao();
		User user = use.findById(4);
		assertEquals(user.getId(),4);
		use.deleteUser(4);
	}
}
