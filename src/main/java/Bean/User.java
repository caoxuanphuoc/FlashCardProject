package Bean;

public class User {

	private Long Id;
	private String FirstName;
	private String LastName;
	private String UserName;
	private String PassWord;
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(Long id, String firstName, String lastName, String userName, String passWord) {
		super();
		Id = id;
		FirstName = firstName;
		LastName = lastName;
		UserName = userName;
		PassWord = passWord;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
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
	public String getPassWord() {
		return PassWord;
	}
	public void setPassWord(String passWord) {
		PassWord = passWord;
	}
	
}
