package Bean;

public class Card {
	private Long Id;
	private Long CollectionId;
	private String FrontText;
	private String BackText;
	private String ImgFront;
	private String ImgBack;
	private boolean IsDelete ;
	
	public Card() {
		// TODO Auto-generated constructor stub
	}

	public Card(Long id, Long collectionId, String frontText, String backText, String imgFront, String imgBack,
			boolean isDelete) {
		super();
		Id = id;
		CollectionId = collectionId;
		FrontText = frontText;
		BackText = backText;
		ImgFront = imgFront;
		ImgBack = imgBack;
		IsDelete = isDelete;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getCollectionId() {
		return CollectionId;
	}

	public void setCollectionId(Long collectionId) {
		CollectionId = collectionId;
	}

	public String getFrontText() {
		return FrontText;
	}

	public void setFrontText(String frontText) {
		FrontText = frontText;
	}

	public String getBackText() {
		return BackText;
	}

	public void setBackText(String backText) {
		BackText = backText;
	}

	public String getImgFront() {
		return ImgFront;
	}

	public void setImgFront(String imgFront) {
		ImgFront = imgFront;
	}

	public String getImgBack() {
		return ImgBack;
	}

	public void setImgBack(String imgBack) {
		ImgBack = imgBack;
	}

	public boolean isIsDelete() {
		return IsDelete;
	}

	public void setIsDelete(boolean isDelete) {
		IsDelete = isDelete;
	}


}
