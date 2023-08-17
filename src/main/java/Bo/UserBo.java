package Bo;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import Bean.User;
import Bean.Dto.FamousRateViewDto;
import Bean.Dto.UserLoginDto;
import Dao.UserDao;

public class UserBo {

	private UserDao dataUser;
	
	public static String ecrypt(String text) throws NoSuchAlgorithmException , UnsupportedEncodingException{
		String enrtext;
		MessageDigest msd=MessageDigest.getInstance("MD5");
		byte[] srctextbyte=text.getBytes("UTF-8"); 
		byte[] enrtextbyte=msd.digest(srctextbyte);
		BigInteger big = new BigInteger(1, enrtextbyte); enrtext=big.toString(16); 
		return enrtext; 
	}
	public UserBo() {
		dataUser= new UserDao();
	}
	public int CreateUser(User info) throws Exception {
		return dataUser.CreateUser(info.getUserName(), info.getEmail(), info.getPassWord());
	}
	public int changePass(Long UserId, String PassWord, String NewPass)throws Exception {
		return dataUser.ChangePass(UserId, PassWord, NewPass);
		
	}
	public UserLoginDto Login(String Un, String Pw) throws Exception{
			String PwMd5 = ecrypt(Pw);
			return dataUser.Login(Un, PwMd5);
	}
	public String GetUserNameById(Long UserId) throws Exception{
		return dataUser.GetUserName(UserId);
	}
	public FamousRateViewDto GetFamousRate(Long UserId) throws Exception {
		return dataUser.GetFamousRate(UserId);
	}
	public boolean UserNameOk(String UserName) throws Exception {
		return dataUser.UserNameOK(UserName);
	}
	public boolean EmailOk(String Email) throws Exception {
		return dataUser.EmailOK(Email);
	}
	
}
