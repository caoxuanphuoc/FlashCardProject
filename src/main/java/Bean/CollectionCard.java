package Bean;

import java.sql.Date;

public class CollectionCard {
	private Long Id;
	private Long UserId;
	private String CollectionName;
	private String Describe;
	private Long Rate;
	private Boolean IsDelete;
	private Integer Status;
	private Date CreateAt;
	private String Password;
	public CollectionCard() {
		// TODO Auto-generated constructor stub
	}
	
	
	public CollectionCard(Long id, Long userId, String collectionName, String describe, Long rate, Boolean isDelete,
			Integer status, Date createAt, String password) {
		super();
		Id = id;
		UserId = userId;
		CollectionName = collectionName;
		Describe = describe;
		Rate = rate;
		IsDelete = isDelete;
		Status = status;
		CreateAt = createAt;
		Password = password;
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
	public String getCollectionName() {
		return CollectionName;
	}
	public void setCollectionName(String collectionName) {
		CollectionName = collectionName;
	}
	public String getDescribe() {
		return Describe;
	}
	public void setDescribe(String describe) {
		Describe = describe;
	}
	public Long getRate() {
		return Rate;
	}
	public void setRate(Long rate) {
		Rate = rate;
	}
	public Boolean getIsDelete() {
		return IsDelete;
	}
	public void setIsDelete(Boolean isDelete) {
		IsDelete = isDelete;
	}
	public Integer getStatus() {
		return Status;
	}
	public void setStatus(Integer status) {
		Status = status;
	}
	public Date getCreateAt() {
		return CreateAt;
	}
	public void setCreateAt(Date createDate) {
		CreateAt = createDate;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
	
}
