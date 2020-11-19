package Test;

import static org.testng.Assert.assertEquals;

import org.junit.Test;

import com.poly.dao.UserDao;
import com.poly.model.User;

public class TestAddUser {
	@Test
	public void addUser() {
		UserDao use = new UserDao();
		User user = new User();
		user.setUsername("Test_User1");
		user.setPassword("12345");
		user.setFullname("Test User1");
		user.setEmail("Test1@gmail.com");
		user.setPhone("'0123456780");
		user.setRole(0);
		use.insertUser(user);
		User newUser = use.findById(4);
		assertEquals(newUser.getUsername(),"Test_User1");

	}

}
