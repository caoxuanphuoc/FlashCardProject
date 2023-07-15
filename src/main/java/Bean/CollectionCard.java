package Bean;

public class CollectionCard {
	private Long Id;
	private Long UserId;
	private String CollectionName;
	private Long Rate;
	private Long CardId;
	public CollectionCard() {
		// TODO Auto-generated constructor stub
	}
	public CollectionCard(Long id, Long userId, String collectionName, Long rate, Long cardId) {
		super();
		Id = id;
		UserId = userId;
		CollectionName = collectionName;
		Rate = rate;
		CardId = cardId;
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
	public Long getCardId() {
		return CardId;
	}
	public void setCardId(Long cardId) {
		CardId = cardId;
	}
	
}
