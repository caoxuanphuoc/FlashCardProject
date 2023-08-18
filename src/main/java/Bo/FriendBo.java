package Bo;

import Dao.FriendDao;

public class FriendBo {
	private FriendDao FDao;
	public FriendBo() {
		FDao = new FriendDao();
	}
	public boolean IsFollow(Long UserId, Long FriendId)throws Exception {
		return FDao.IsFollow(UserId, FriendId);
	}
	 
	public boolean CreateFollow(Long UserId, Long FriendId)throws Exception {
		return FDao.AddRelate(UserId, FriendId);
	}
}
