package Bo;

import java.util.ArrayList;

import Bean.User;
import Bean.Dto.UserLoginDto;
import Dao.UserDao;

public class UserBo {

	private UserDao dataUser;
	public UserBo() {
		dataUser= new UserDao();
	}
	
	public UserLoginDto Login(String Un, String Pw) throws Exception{
		User u = dataUser.Login(Un, Pw);
		if(u!= null)
			return new UserLoginDto(u.getId(), u.getFirstName(), u.getLastName(), u.getUserName());
		return null;
	}
	
}
