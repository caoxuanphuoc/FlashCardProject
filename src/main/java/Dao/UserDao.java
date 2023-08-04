package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.User;

public class UserDao {

	public UserDao() {
		// TODO Auto-generated constructor stub
	}
	public User Login(String un , String pw) throws Exception{
		ArrayList<User> DS = new ArrayList<User>();
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
		User _user = null;
		if( rs.next()) {
			long id = rs.getLong("id");
			String FirstName = rs.getString("FirstName");
			String LastName = rs.getString("LastName");
			String UserName = rs.getString("UserName");
			boolean IsActive = rs.getBoolean("IsActive");
			_user =new User(id, FirstName, LastName, UserName, IsActive);
		}
		return _user;
	}
	

}
