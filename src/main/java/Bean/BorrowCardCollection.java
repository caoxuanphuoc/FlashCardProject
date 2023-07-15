package Bean;

public class BorrowCardCollection {
	private Long Id;
	private Long UserId;
	private Long CollectionId;
	public BorrowCardCollection() {
		// TODO Auto-generated constructor stub
	}
	public BorrowCardCollection(Long id, Long userId, Long collectionId) {
		super();
		Id = id;
		UserId = userId;
		CollectionId = collectionId;
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
	public Long getCollectionId() {
		return CollectionId;
	}
	public void setCollectionId(Long collectionId) {
		CollectionId = collectionId;
	}
	
}
