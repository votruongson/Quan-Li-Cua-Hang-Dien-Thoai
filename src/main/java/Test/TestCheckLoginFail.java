package Test;

import static org.testng.Assert.assertEquals;

import org.junit.Test;

import com.poly.dao.UserDao;
import com.poly.model.User;

public class TestCheckLoginFail {
	@Test
	public void CheckFalseLogin() {
		String username = "Teo";
		String password = "1235";
		UserDao use = new UserDao();
		User user = use.CheckLogin(username, password);
		assertEquals(user.getUsername(), username);
		assertEquals(user.getPassword(), password);
	}
}
