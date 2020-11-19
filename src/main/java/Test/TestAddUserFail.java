package Test;

import static org.testng.Assert.assertEquals;

import org.junit.Test;

import com.poly.dao.UserDao;
import com.poly.model.User;

public class TestAddUserFail {
	@Test
	public void addUser() {
		UserDao use = new UserDao();
		User user = new User();
		user.setUsername("Test_User11");
		user.setPassword("123455");
		user.setFullname("");
		user.setEmail("Test11@gmail.com");
		user.setPhone("'012345670");
		user.setRole(0);
		use.insertUser(user);
		User newUser = use.findById(5);
		assertEquals(newUser.getUsername(),"Test_User11");

	}

}
