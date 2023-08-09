package Bean.Dto;

public class UserLoginDto {
	private long UserId;
	private String FirstName;
	private String LastName;
	private String UserName;
	public UserLoginDto() {
		// TODO Auto-generated constructor stub
	}
	public UserLoginDto(long userId, String firstName, String lastName, String userName) {
		super();
		UserId = userId;
		FirstName = firstName;
		LastName = lastName;
		UserName = userName;
	}
	@Override
	public String toString() {
		return "UserLoginDto [UserId=" + UserId + ", FirstName=" + FirstName + ", LastName=" + LastName + ", UserName="
				+ UserName + "]";
	}
	public long getUserId() {
		return UserId;
	}
	public void setUserId(long userId) {
		UserId = userId;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getFullName() {
		return LastName + " " + FirstName;
	}
}
