package Dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.CollectionCard;
import Bean.User;

public class CollectionDao {

	public CollectionDao() {
		// TODO Auto-generated constructor stub
	}
	//--------------------GET-ALL-------------------
	public ArrayList<CollectionCard> GetAllCollection() throws Exception{
		ArrayList<CollectionCard> DS = new ArrayList<CollectionCard>();
		ConnectFCLEDb kn = new ConnectFCLEDb();
		kn.ketnoi();
		// b2: tao cau lenh sql
		String sql = "select * from CollectionCard where IsDelete is null or IsDelete = 0 order by CreateAt desc";
		// b3: tao cau lenh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		// b4: thuc hien cau lenh
		ResultSet rs = cmd.executeQuery();
		while( rs.next()) {
			long Id = rs.getLong("Id");
			long UserId = rs.getLong("UserId");
			String CollectionName = rs.getString("collectionName");
			String Describe = rs.getString("Describe");
			long Rate = rs.getLong("rate");
			Boolean IsDelete = rs.getBoolean("IsDelete");
			int Status = rs.getInt("Status");
			Date CreateAt = rs.getDate("CreateAt");
			String Password = rs.getString("Password");
			DS.add(new CollectionCard(Id, UserId, CollectionName, Describe, Rate, IsDelete, Status, CreateAt, Password));
		}
		cmd.close();
		 kn.cn.close();
		return DS;
	}
	//-------------------Get-By-ID------------------
	public CollectionCard GetCollection(Long id) throws Exception{
		CollectionCard Col = new CollectionCard();
		ConnectFCLEDb kn = new ConnectFCLEDb();
		kn.ketnoi();
		// b2: tao cau lenh sql
		String sql = "select * from CollectionCard where id = ? AND( IsDelete is null or IsDelete = 0) order by CreateAt desc";
		// b3: tao cau lenh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		// b4: thuc hien cau lenh
		cmd.setLong(1, id);
		ResultSet rs = cmd.executeQuery();
		while( rs.next()) {
			long Id = rs.getLong("Id");
			long UserId = rs.getLong("UserId");
			String CollectionName = rs.getString("collectionName");
			String Describe = rs.getString("Describe");
			long Rate = rs.getLong("rate");
			Boolean IsDelete = rs.getBoolean("IsDelete");
			int Status = rs.getInt("Status");
			Date CreateAt = rs.getDate("CreateAt");
			String Password = rs.getString("Password");
			Col =new CollectionCard(Id, UserId, CollectionName, Describe, Rate, IsDelete, Status, CreateAt, Password);
		}
		cmd.close();
		 kn.cn.close();
		return Col;
	}
	//-------------------GET ALL-By-IDUSER-------------
	public ArrayList<CollectionCard> GetAllCollectionByUser(Long idUser) throws Exception{
		ArrayList<CollectionCard> DS = new ArrayList<CollectionCard>();
		ConnectFCLEDb kn = new ConnectFCLEDb();
		kn.ketnoi();
		// b2: tao cau lenh sql
		String sql = "select * from CollectionCard where UserId = ? AND (IsDelete is null or IsDelete = 0 )order by CreateAt desc";
		// b3: tao cau lenh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, idUser);
		// b4: thuc hien cau lenh
		ResultSet rs = cmd.executeQuery();
		while( rs.next()) {
			long Id = rs.getLong("Id");
			long UserId = rs.getLong("UserId");
			String CollectionName = rs.getString("collectionName");
			String Describe = rs.getString("Describe");
			long Rate = rs.getLong("rate");
			Boolean IsDelete = rs.getBoolean("IsDelete");
			int Status = rs.getInt("Status");
			Date CreateAt = rs.getDate("CreateAt");
			String Password = rs.getString("Password");
			DS.add(new CollectionCard(Id, UserId, CollectionName, Describe, Rate, IsDelete, Status, CreateAt, Password));
		}
		cmd.close();
		 kn.cn.close();
		return DS;
	}
	//--------------------------CREATE------------------------------------------
	public int CreateCollectionCard(Long userId, String collectionName, String describe)  throws Exception{
		CollectionCard CC = new CollectionCard();
		ConnectFCLEDb kn = new ConnectFCLEDb();
		kn.ketnoi();
		// b2: tao cau lenh sql
		String sql = "INSERT INTO CollectionCard (userId, collectionName, describe) VALUES (?,?,?)";
		// b3: tao cau lenh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		
		cmd.setLong(1, userId);
		cmd.setString(2, collectionName);
		cmd.setString(3, describe);
		
		 int kq = cmd.executeUpdate();
		 cmd.close();
		 kn.cn.close();
		 return kq;
		
	}
	//---------------------UPDATE---------------------
	public int UpdateCollectionCard(Long id, Long userId, String collectionName, String describe, Long rate, boolean isDelete,
			int status, String password)  throws Exception{
		CollectionCard CC = new CollectionCard();
		ConnectFCLEDb kn = new ConnectFCLEDb();
		kn.ketnoi();
		// b2: tao cau lenh sql
		String sql = "Update  CollectionCard SET userId = ?,collectionName = ?,describe= ?, rate= ?,isDelete= ?,status= ?, Password = ? where Id =?";
		// b3: tao cau lenh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		
		cmd.setLong(1, userId);
		cmd.setString(2, collectionName);
		cmd.setString(3, describe);
		cmd.setLong(4, rate);
		cmd.setBoolean(5, isDelete);
		cmd.setInt(6, status);
		cmd.setString(7,password );
		cmd.setLong(8, id);
		 int kq = cmd.executeUpdate();
		 cmd.close();
		 kn.cn.close();
		 return kq;
		
	}
	
	
	public int DeleteCollectionCard(Long Id)  throws Exception{
		CollectionCard CC = new CollectionCard();
		ConnectFCLEDb kn = new ConnectFCLEDb();
		kn.ketnoi();
		// b2: tao cau lenh sql
		String sql = "Update  CollectionCard SET Isdelete = 1 where Id =?";
		// b3: tao cau lenh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		
		cmd.setLong(1, Id);;
		
		 int kq = cmd.executeUpdate();
		 cmd.close();
		 kn.cn.close();
		 return kq;
		
	}
	public int QuantityCard(long IdCollection) throws Exception {
		ConnectFCLEDb kn = new ConnectFCLEDb();
		kn.ketnoi();
		String sql = "select CollectionCard.Id, count(*) as quan\r\n"
				+ "from CollectionCard inner join\r\n"
				+ "	Card ON CollectionCard.Id = Card.CollectionId\r\n"
				+ "where CollectionCard.Id = ? \r\n"
				+ "Group by CollectionCard.Id";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, IdCollection);
		ResultSet rs = cmd.executeQuery();
		
		int quan = 0;
		if(rs.next()) {
			quan = rs.getInt("quan");
		}
		rs.close();
		kn.cn.close();
		return quan;
	}
	private long MaxID() throws Exception {
		ConnectFCLEDb kn = new ConnectFCLEDb();
		kn.ketnoi();
		String sql = "select Max(Id) from CollectionCard";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		
		long max = 0;
		if(rs.next()) {
			max = rs.getLong(1);
		}
		rs.close();
		kn.cn.close();
		return max;
	}
}
