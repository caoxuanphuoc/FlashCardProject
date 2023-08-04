package Bean.Dto;

public class UserLoginDto {

	private String FirstName;
	private String LastName;
	private String UserName;
	public UserLoginDto() {
		// TODO Auto-generated constructor stub
	}
	public UserLoginDto(String firstName, String lastName, String userName) {
		super();
		FirstName = firstName;
		LastName = lastName;
		UserName = userName;
	}
	@Override
	public String toString() {
		return "UserLoginDto [FirstName=" + FirstName + ", LastName=" + LastName + ", UserName=" + UserName + "]";
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
	
}
