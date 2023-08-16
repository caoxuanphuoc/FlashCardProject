package Dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.User;
import Bean.Dto.FamousRateViewDto;
import Bean.Dto.UserLoginDto;

public class UserDao {

	public UserDao() {
		// TODO Auto-generated constructor stub
	}
	public UserLoginDto Login(String un , String pw) throws Exception{
		ConnectFCLEDb kn = new ConnectFCLEDb();
		kn.ketnoi();
		// b2: tao cau lenh sql
		String sql = "select * from Users Where UserName=? and Password=?";
		// b3: tao cau lenh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, un);
		cmd.setString(2, pw);
		// b4: thuc hien cau lenh
		ResultSet rs = cmd.executeQuery();
		UserLoginDto _user = null;
		if( rs.next()) {
			long id = rs.getLong("id");
			String FirstName = rs.getString("FirstName");
			String LastName = rs.getString("LastName");
			String UserName = rs.getString("UserName");
			boolean IsActive = rs.getBoolean("IsActive");
			String intro= rs.getString("Intro");;
			String email= rs.getString("Email");;
			Date dateOfBirth= rs.getDate("dateOfBirth");;
			Date createdAt = rs.getDate("CreatedAt");;
			_user =new UserLoginDto(id, FirstName, LastName, UserName, intro, email, dateOfBirth, createdAt);
		}
		return _user;
	}
	public String GetUserName(Long Id) throws Exception{
		ConnectFCLEDb kn = new ConnectFCLEDb();
		kn.ketnoi();
		// b2: tao cau lenh sql
		String sql = "select * from Users Where id=?";
		// b3: tao cau lenh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, Id);
		// b4: thuc hien cau lenh
		ResultSet rs = cmd.executeQuery();
		String res ="";
		if( rs.next()) {			
			res = rs.getString("userName");
		}
		return res;
	}
	public FamousRateViewDto GetFamousRate(Long UserId) throws Exception {
		ConnectFCLEDb kn = new ConnectFCLEDb();
		kn.ketnoi();
		// b2: tao cau lenh sql
		String sql = "select * from FamousRateView Where UserId=?";
		// b3: tao cau lenh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, UserId);
		ResultSet rs = cmd.executeQuery();
		FamousRateViewDto res = new FamousRateViewDto();
		if( rs.next()) {			
			Long userId = rs.getLong("UserId");
			Long following = rs.getLong("following");
			Long follower = rs.getLong("follower");
			Long rate = rs.getLong("Rare");
			res = new FamousRateViewDto(UserId, following, follower, rate);
		}
		return res;
	}
	

}
