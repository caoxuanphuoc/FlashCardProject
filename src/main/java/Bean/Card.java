package Bean;

public class Card {
	private Long Id;
	private Long CollectionId;
	private String FrontText;
	private String BackText;
	private String ImgFront;
	private String ImgBack;
	private Boolean IsDelete ;
	
	public Card() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Card [Id=" + Id + ", CollectionId=" + CollectionId + ", FrontText=" + FrontText + ", BackText="
				+ BackText + ", ImgFront=" + ImgFront + ", ImgBack=" + ImgBack + ", IsDelete=" + IsDelete + "]";
	}

	public Card(Long id, Long collectionId, String frontText, String backText, String imgFront, String imgBack,
			Boolean isDelete) {
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

	public Boolean isIsDelete() {
		return IsDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		IsDelete = isDelete;
	}
	public String RequestURL() {
		try {
			
		
		String url="?";
		if(Id !=null)
			url = url + "Id=" + Id.toString();
		
		if(CollectionId !=null && url.equals("?"))
			url = url + "CollectionId=" + CollectionId.toString();
		else {
			if(CollectionId!=null && url.equals("?")== false )
				url = url + "&CollectionId=" + CollectionId.toString();
		}
		//--------------------------------
		if(FrontText !=null && url.equals("?"))
			url = url + "FrontText=" + FrontText.toString();
		else {
			if(FrontText!=null && url.equals("?")== false )
				url = url + "&FrontText=" + FrontText;
		}
		
		if(BackText !=null && url.equals("?"))
			url = url + "BackText=" + BackText;
		else {
			if(BackText!=null && url.equals("?")== false )
				url = url + "&BackText=" + BackText;
		}
		
		if(ImgFront !=null && url.equals("?"))
			url = url + "ImgFront=" + ImgFront;
		else {
			if(ImgFront!=null && url.equals("?")== false )
				url = url + "&ImgFront=" + ImgFront;
		}
		
		if(ImgBack !=null && url.equals("?"))
			url = url + "ImgBack=" + ImgBack;
		else {
			if(IsDelete!=null && url.equals("?")== false )
				url = url + "&ImgBack=" + ImgBack;
		}
		
		if( IsDelete!=null && url.equals("?"))
			url = url + "IsDelete=" + IsDelete.toString();
		else {
			if(IsDelete!=null && url.equals("?")== false )
				url = url + "&IsDelete=" + IsDelete.toString();
		}
		
		if(url.equals("?"))
			url="";
		return url;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "co cc";
	}


}
