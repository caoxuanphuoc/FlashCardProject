package Bo;

import Dao.ConnectFCLEDb;
import Dao.FriendDao;

public class FriendBo {
	private FriendDao FDao;
	public FriendBo() {
		FDao = new FriendDao();
	}
	public boolean IsFollow(Long UserId, Long FriendId)throws Exception {
		return FDao.IsFollow(UserId, FriendId);
	}
	
	public boolean CheckRecord(Long UserId, Long FriendId)throws Exception {
		return FDao.CheckRecord(UserId, FriendId);
	}
	 
	public int CreateFriend(Long UserId, Long FriendId)throws Exception {
		return FDao.CreateFriend(UserId, FriendId);
	}
	public int UpdateFriend(Long UserId, Long FriendId, Boolean IsFriend)throws Exception {
		return FDao.Update(UserId, FriendId, IsFriend);
	}
	
	//--------------------SET Relate-------------------------
	public String SetRelate(Long UserId, Long FriendId, Boolean IsFriend) throws Exception {
			if(IsFriend == true) { //if set Follow
				//Check exist record
				if(CheckRecord(UserId, FriendId)) {
					UpdateFriend(UserId, FriendId, IsFriend);
					return "REFollow";
				}else {
					CreateFriend(UserId, FriendId);
					return "NEWFollow";
				}
			}else { //unfollow 
				System.out.println("dam bao IsFriend= " + IsFriend);
				UpdateFriend(UserId, FriendId, IsFriend);
				return "UNFollow";
			}
	}
}
