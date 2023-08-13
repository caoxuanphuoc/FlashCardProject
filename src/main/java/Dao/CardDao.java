package Dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.Card;
import Bean.CollectionCard;

public class CardDao {

	public CardDao() {
		// TODO Auto-generated constructor stub
	}
	//-------------------Get-cardBy_iD_card
	public Card GetAllCardById(long CoID) throws Exception{
		Card CardC =new Card();
		ConnectFCLEDb kn = new ConnectFCLEDb();
		kn.ketnoi();
		// b2: tao cau lenh sql
		String sql = "select * from Card where Id = ? and ( IsDelete is null or IsDelete = 0) ";
		// b3: tao cau lenh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, CoID);
		// b4: thuc hien cau lenh
		ResultSet rs = cmd.executeQuery();
		if( rs.next()) {
			long Id = rs.getLong("Id");
			long CollectionId = rs.getLong("CollectionId");
			String FrontText = rs.getString("FrontText");
			String BackText = rs.getString("BackText");
			String ImgFront = rs.getString("ImgFront");
			String ImgBack = rs.getString("ImgBack");
			Boolean IsDelete = rs.getBoolean("IsDelete");
			CardC = new Card(Id, CollectionId, FrontText, BackText, ImgFront, ImgBack, IsDelete);
		}
		cmd.close();
		 kn.cn.close();
		return CardC;
	}
	//-------------------Get-card-by-IDColection
	public ArrayList<Card> GetAllCardByCoID(long CoID) throws Exception{
		ArrayList<Card> DS = new ArrayList<Card>();
		ConnectFCLEDb kn = new ConnectFCLEDb();
		kn.ketnoi();
		// b2: tao cau lenh sql
		String sql = "select * from Card where CollectionId = ? and ( IsDelete is null or IsDelete = 0) ";
		// b3: tao cau lenh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, CoID);
		// b4: thuc hien cau lenh
		ResultSet rs = cmd.executeQuery();
		while( rs.next()) {
			long Id = rs.getLong("Id");
			long CollectionId = rs.getLong("CollectionId");
			String FrontText = rs.getString("FrontText");
			String BackText = rs.getString("BackText");
			String ImgFront = rs.getString("ImgFront");
			String ImgBack = rs.getString("ImgBack");
			Boolean IsDelete = rs.getBoolean("IsDelete");
			DS.add(new Card(Id, CollectionId, FrontText, BackText, ImgFront, ImgBack, IsDelete));
		}
		cmd.close();
		 kn.cn.close();
		return DS;
	}
	//--------------------------CREATE------------------------------------------
		public int CreateCard(Long CollectionId, String FrontText, String BackText, String ImgFront, String ImgBack)  throws Exception{
			CollectionCard CC = new CollectionCard();
			ConnectFCLEDb kn = new ConnectFCLEDb();
			kn.ketnoi();
			// b2: tao cau lenh sql
			String sql = "INSERT INTO Card ( CollectionId, FrontText, BackText, ImgFront, ImgBack) VALUES (?, ?, ?, ?,?)";
			// b3: tao cau lenh
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			
			
			cmd.setLong(1, CollectionId);
			cmd.setString(2, FrontText);
			cmd.setString(3, BackText);
			cmd.setString(4, ImgFront);
			cmd.setString(5, ImgBack);
			
			 int kq = cmd.executeUpdate();
			 cmd.close();
			 kn.cn.close();
			 return kq;
			
		}
		//---------------------UPDATE---------------------
		public int UpdateCard(Long id, Long CollectionId, String FrontText, String BackText, String ImgFront, String ImgBack, boolean isDelete)  throws Exception{
			CollectionCard CC = new CollectionCard();
			ConnectFCLEDb kn = new ConnectFCLEDb();
			kn.ketnoi();
			// b2: tao cau lenh sql
			String sql = "Update  Card SET CollectionId = ?,FrontText= ?, BackText= ?,ImgFront= ?,ImgBack= ? , IsDelete =? where Id =?";
			// b3: tao cau lenh
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			
			cmd.setLong(1, CollectionId);
			cmd.setString(2, FrontText);
			cmd.setString(3, BackText);
			cmd.setString(4, ImgFront);
			cmd.setString(5, ImgBack);
			cmd.setBoolean(6, isDelete);
			cmd.setLong(7, id);
			 int kq = cmd.executeUpdate();
			 cmd.close();
			 kn.cn.close();
			 return kq;
			
		}
		//-----------------Delete
		public int DeleteCard(Long Id)  throws Exception{
			CollectionCard CC = new CollectionCard();
			ConnectFCLEDb kn = new ConnectFCLEDb();
			kn.ketnoi();
			// b2: tao cau lenh sql
			String sql = "Update  Card SET Isdelete = 1 where Id =?";
			// b3: tao cau lenh
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			
			cmd.setLong(1, Id);;
			
			 int kq = cmd.executeUpdate();
			 cmd.close();
			 kn.cn.close();
			 return kq;
			
		}
}
