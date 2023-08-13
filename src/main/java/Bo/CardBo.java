package Bo;

import java.util.ArrayList;

import Bean.Card;
import Bean.CollectionCard;
import Bean.Dto.CollectionDtos.Collectiondto;
import Dao.CardDao;
import Dao.CollectionDao;

public class CardBo {
	private CardDao card;
	public CardBo() {
		card = new CardDao();
		System.out.println("tao thanh cong");
	}
	//--------GET-ALL-By-IDCOLLECTON------
	public ArrayList<Card> GetAll(long CoID) throws Exception {
		ArrayList<Card> ls = card.GetAllCardByCoID(CoID);
		
		return ls;
	}
	//--------Get-BY-IDCard------
	public Card GetById(long CardId) throws Exception {
		System.out.println("nhan doi tuong");
		return card.GetAllCardById(CardId);
	}
	//--------CREATE--------
	public int Create(Long CollectionId, String FrontText, String BackText, String ImgFront, String ImgBack) throws Exception {
		CardDao card2 = new CardDao();
		return card2.CreateCard( CollectionId,  FrontText,  BackText,  ImgFront,  ImgBack);
	}
	
	//--------DELETE--------
	public int Delete(Long Id) throws Exception {
		return card.DeleteCard(Id);
	}
	
	//--------UPDATE--------
	public int Update(Card cardn) throws Exception {
		Card C = new Card(Long.parseLong("4"),(long) 1, "rrrr", "ngon" , "", "", false);
		
		return card.UpdateCard(cardn.getId(), cardn.getCollectionId(), cardn.getFrontText(), cardn.getBackText(), cardn.getImgFront(), cardn.getImgBack(), cardn.isIsDelete()) ;
	}
}
