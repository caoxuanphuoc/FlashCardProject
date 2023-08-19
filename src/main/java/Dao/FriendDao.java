package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Bean.CollectionCard;
import Bean.Dto.FamousRateViewDto;

public class FriendDao {

	public FriendDao() {
		// TODO Auto-generated constructor stub
	}
	// ------------------ isFollow
	public boolean IsFollow(Long UserId, Long FriendId) throws Exception {
		ConnectFCLEDb kn = new ConnectFCLEDb();
		kn.ketnoi();
		// b2: tao cau lenh sql
		String sql = "select * from Friend where userid = ? and FriendId = ? and IsFriend =1";
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
	//-------------------Check-exist-record----------------
	public boolean CheckRecord(Long UserId, Long FriendId) throws Exception {
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
	//---------------UPDATE-----------------
	public int Update(Long UserId, Long FriendId, Boolean IsFriend)  throws Exception{
		ConnectFCLEDb kn = new ConnectFCLEDb();
		kn.ketnoi();
		// b2: tao cau lenh sql
		String sql = "Update  Friend SET IsFriend = ? where userid = ? and FriendId = ?";
		// b3: tao cau lenh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		
		cmd.setBoolean(1, IsFriend);
		cmd.setLong(2, UserId);
		cmd.setLong(3, FriendId);
		 int kq = cmd.executeUpdate();
		 cmd.close();
		 kn.cn.close();
		 return kq;
		
	}
	//-----------CREATE--------------------
	public int CreateFriend(Long UserId, Long FriendId)  throws Exception{
		ConnectFCLEDb kn = new ConnectFCLEDb();
		kn.ketnoi();
		// b2: tao cau lenh sql
		String sql = "INSERT INTO Card ( UserId, FriendId) VALUES (?,?)";
		// b3: tao cau lenh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		
		
		cmd.setLong(1, UserId);
		cmd.setLong(2, FriendId);
		
		 int kq = cmd.executeUpdate();
		 cmd.close();
		 kn.cn.close();
		 return kq;
		
	}
	
	
}
