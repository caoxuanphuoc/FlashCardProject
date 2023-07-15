package Bean;

public class Card {
	private Long Id;
	private String FrontText;
	private String BackText;
	private String ImageText;
	
	public Card() {
		// TODO Auto-generated constructor stub
	}

	public Card(Long id, String frontText, String backText, String imageText) {
		super();
		Id = id;
		FrontText = frontText;
		BackText = backText;
		ImageText = imageText;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
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

	public String getImageText() {
		return ImageText;
	}

	public void setImageText(String imageText) {
		ImageText = imageText;
	}

}
