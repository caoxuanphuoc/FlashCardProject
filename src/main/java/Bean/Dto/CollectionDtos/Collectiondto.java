package Bean.Dto.CollectionDtos;

import java.sql.Date;

public class Collectiondto {
	private Long Id;
	private Long UserId;
	private String UserName;
	private String CollectionName;
	private String Describe;
	private Long Rate;
	private boolean IsDelete;
	private int Status;
	private Date CreateAt;
	private int Quantity;
	
	public Collectiondto(Long id, Long userId, String userName, String collectionName, String describe, Long rate, boolean isDelete,
			int status, Date createAt, int quantity) {
		super();
		Id = id;
		UserId = userId;
		UserName = userName;
		CollectionName = collectionName;
		Describe = describe;
		Rate = rate;
		IsDelete = isDelete;
		Status = status;
		CreateAt = createAt;
		Quantity = quantity;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public Collectiondto() {
		// TODO Auto-generated constructor stub
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

	public boolean isIsDelete() {
		return IsDelete;
	}

	public void setIsDelete(boolean isDelete) {
		IsDelete = isDelete;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}

	public Date getCreateAt() {
		return CreateAt;
	}

	public void setCreateAt(Date createAt) {
		CreateAt = createAt;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	

}
