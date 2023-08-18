package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Bean.Dto.FamousRateViewDto;

public class FriendDao {

	public FriendDao() {
		// TODO Auto-generated constructor stub
	}
	public boolean IsFollow(Long UserId, Long FriendId) throws Exception {
		ConnectFCLEDb kn = new ConnectFCLEDb();
		kn.ketnoi();
		// b2: tao cau lenh sql
		String sql = "select * from Friend where userid = ? and FriendId = ?";
		// b3: tao cau lenh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, UserId);
		cmd.setLong(2, FriendId);
		ResultSet rs = cmd.executeQuery();
		if( rs.next()) {			
			return true;
		}
		return false;
	}
	public boolean AddRelate(Long UserId, Long FriendId) throws Exception {
		if(IsFollow(UserId,FriendId)==false) {
			//check Friend
			Boolean isFriend = IsFollow(FriendId, UserId);
			
			ConnectFCLEDb kn = new ConnectFCLEDb();
			kn.ketnoi();
			// b2: tao cau lenh sql
			String sql = "INSERT INTO  Friend ( UserId , FriendId, IsFriend) VALUES (?,?,?)";
			// b3: tao cau lenh
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setLong(1, UserId);
			cmd.setLong(2, FriendId);
			cmd.setBoolean(3, isFriend);
			int rs = cmd.executeUpdate();
			if( rs ==1) {			
				return true;
			}
			return false;}
		else {
			return false;
		}
	}
}
