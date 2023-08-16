package Bo;

import java.util.ArrayList;

import Bean.User;
import Bean.Dto.FamousRateViewDto;
import Bean.Dto.UserLoginDto;
import Dao.UserDao;

public class UserBo {

	private UserDao dataUser;
	public UserBo() {
		dataUser= new UserDao();
	}
	
	public UserLoginDto Login(String Un, String Pw) throws Exception{
			return dataUser.Login(Un, Pw);
	}
	public String GetUserNameById(Long UserId) throws Exception{
		return dataUser.GetUserName(UserId);
	}
	public FamousRateViewDto GetFamousRate(Long UserId) throws Exception {
		return dataUser.GetFamousRate(UserId);
	}
	
}
