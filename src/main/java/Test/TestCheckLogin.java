package Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.junit.Test;

import com.poly.dao.UserDao;
import com.poly.model.User;

public class TestCheckLogin {
	@Test
	public void CheckTrueLogin() {
		String username = "Linh";
		String password = "123456";
		UserDao use = new UserDao();
		User user = use.CheckLogin(username, password);
		assertEquals(user.getUsername(), username);
		assertEquals(user.getPassword(), password);

	}
}
