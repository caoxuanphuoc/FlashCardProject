package Bean;

public class Friend {
	private Long Id;
	private Long UserId;
	private Long FriendId;
	private Boolean IsFriend;
	public Friend() {
		// TODO Auto-generated constructor stub
	}
	
	public Friend(Long id, Long userId, Long friendId, Boolean isFriend) {
		super();
		Id = id;
		UserId = userId;
		FriendId = friendId;
		IsFriend = isFriend;
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
	public Boolean getIsFriend() {
		return IsFriend;
	}
	public void setIsFriend(Boolean isFriend) {
		IsFriend = isFriend;
	}

}
