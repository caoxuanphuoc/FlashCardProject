package Bean;

public class CollectionCard {
	private Long Id;
	private Long UserId;
	private String CollectionName;
	private Long Rate;
	private boolean IsDelete;
	private int Status;
	public CollectionCard() {
		// TODO Auto-generated constructor stub
	}
	public CollectionCard(Long id, Long userId, String collectionName, Long rate, boolean isDelete) {
		super();
		Id = id;
		UserId = userId;
		CollectionName = collectionName;
		Rate = rate;
		IsDelete = isDelete;
		Status =1;
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
	
	
}
