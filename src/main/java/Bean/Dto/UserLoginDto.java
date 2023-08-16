package Bean.Dto;

import java.sql.Date;

public class UserLoginDto {
	private long UserId;
	private String FirstName;
	private String LastName;
	private String UserName;
	private String Intro;
	private String Email;
	private Date DateOfBirth;
	private Date CreatedAt;
	public UserLoginDto() {
		// TODO Auto-generated constructor stub
	}
	
	public UserLoginDto(long userId, String firstName, String lastName, String userName, String intro, String email,
			Date dateOfBirth, Date createdAt) {
		super();
		UserId = userId;
		FirstName = firstName;
		LastName = lastName;
		UserName = userName;
		Intro = intro;
		Email = email;
		DateOfBirth = dateOfBirth;
		CreatedAt = createdAt;
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

	public String getIntro() {
		return Intro;
	}

	public void setIntro(String intro) {
		Intro = intro;
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
}
