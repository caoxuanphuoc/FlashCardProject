package Bean;

import java.sql.Date;

public class User {

	private Long Id;
	private String FirstName;
	private String LastName;
	private String UserName;
	private String PassWord;
	private boolean IsDelete;
	private boolean IsActive;
	private String Email;
	private Date DateOfBirth;
	private Date CreatedAt;
	private String Intro;
	public User() {
		super();
	}
	// model user for session
	public User(Long id, String firstName, String lastName, String userName,boolean isActive) {
		super();
		Id = id;
		FirstName = firstName;
		LastName = lastName;
		UserName = userName;
		IsActive = isActive;
	}
	
	// -------------Create-Account
	
	public User(String userName, String passWord, String email) {
		super();
		UserName = userName;
		PassWord = passWord;
		Email = email;
	}
	public User(Long id, String firstName, String lastName, String userName, String passWord, boolean isDelete,
			boolean isActive, String email, Date dateOfBirth, Date createdAt, String intro) {
		super();
		Id = id;
		FirstName = firstName;
		LastName = lastName;
		UserName = userName;
		PassWord = passWord;
		IsDelete = isDelete;
		IsActive = isActive;
		Email = email;
		DateOfBirth = dateOfBirth;
		CreatedAt = createdAt;
		Intro = intro;
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
	public boolean isIsDelete() {
		return IsDelete;
	}
	public void setIsDelete(boolean isDelete) {
		IsDelete = isDelete;
	}
	public boolean isIsActive() {
		return IsActive;
	}
	public void setIsActive(boolean isActive) {
		IsActive = isActive;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public Date getDateOfBirth() {
		return DateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}
	public Date getCreatedAt() {
		return CreatedAt;
	}
	public void setCreatedAt(Date createdAt) {
		CreatedAt = createdAt;
	}
	public String getIntro() {
		return Intro;
	}
	public void setIntro(String intro) {
		Intro = intro;
	}
	
	
}
