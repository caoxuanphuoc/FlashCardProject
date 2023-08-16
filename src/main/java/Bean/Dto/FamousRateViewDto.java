package Bean.Dto;

public class FamousRateViewDto {
	private Long UserId;
	private Long Following;
	private Long Follower;
	private Long Rate;
	
	public FamousRateViewDto() {
		// TODO Auto-generated constructor stub
	}

	public FamousRateViewDto(Long userId, Long following, Long follower, Long rate) {
		super();
		UserId = userId;
		Following = following;
		Follower = follower;
		Rate = rate;
	}

	public Long getUserId() {
		return UserId;
	}

	public void setUserId(Long userId) {
		UserId = userId;
	}

	public Long getFollowing() {
		return Following;
	}

	public void setFollowing(Long following) {
		Following = following;
	}

	public Long getFollower() {
		return Follower;
	}

	public void setFollower(Long follower) {
		Follower = follower;
	}

	public Long getRate() {
		return Rate;
	}

	public void setRate(Long rate) {
		Rate = rate;
	}
	

}
