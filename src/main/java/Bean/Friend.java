package Bean;

public class Friend {
	private Long Id;
	private Long UserId;
	private Long FriendId;
	private boolean IsFriend;
	private boolean IsDelete;
	public Friend() {
		// TODO Auto-generated constructor stub
	}
	public Friend(Long id, Long userId, Long friendId, boolean isFriend, boolean isDelete) {
		super();
		Id = id;
		UserId = userId;
		FriendId = friendId;
		IsFriend = isFriend;
		IsDelete = isDelete;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public Long getUserId() {
		return UserId;
	}
	public void setUserId(Long userId) {
		UserId = userId;
	}
	public Long getFriendId() {
		return FriendId;
	}
	public void setFriendId(Long friendId) {
		FriendId = friendId;
	}
	public boolean isIsFriend() {
		return IsFriend;
	}
	public void setIsFriend(boolean isFriend) {
		IsFriend = isFriend;
	}
	public boolean isIsDelete() {
		return IsDelete;
	}
	public void setIsDelete(boolean isDelete) {
		IsDelete = isDelete;
	}
	
	

}
