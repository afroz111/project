import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.capg.oms.dao.UserDao;
import com.capg.oms.dao.UserDaoImpl;
import com.capg.oms.model.User;
import com.capg.oms.service.UserService;
import com.capg.oms.service.UserServiceImpl;


public class AppTest
{
UserDao dao=new UserDaoImpl();
UserService service=new UserServiceImpl();
static Map<Long,User> userList=new HashMap<Long , User>();
static Map<Long,User> userList2=new HashMap<Long , User>();
static User user;

@BeforeAll
public static void addSomeAdmins() {
User user=new User(1234L,"Afroz","afroz624",9542785713L,"afroz@gmail.com");
userList.put(user.getUserId(),user);
userList.put(user.getUserPhone(),user);
//userList.put(user.getUserEmail(), user);
}



@Test
public void UserId() {
assertEquals(user, service.viewUser(1234));
}

//@Test
//public void UserPassword() {
//assertEquals(user, service.viewUser(12345678));
//}
	/*
	 * @Test public void validPhoneNo(Long phoneno) {
	 * assertEquals(user,service.toString()); }
	 * 
	 */
@Test
public void UserPhone() {

	
	assertEquals(user,service.viewUser(9542785723L));
}

}

