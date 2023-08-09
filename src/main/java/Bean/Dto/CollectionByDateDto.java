package Bean.Dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import Bean.CollectionCard;
import Bo.CollectionBo;

public class CollectionByDateDto {
	private Date CreatedAt;
	private ArrayList<CollectionCard> ListCollection;
	public CollectionByDateDto() {
		ListCollection =new ArrayList<CollectionCard>();
		// TODO Auto-generated constructor stub
	}
	public Date getCreatedAt() {
		return CreatedAt;
	}
	public void setCreatedAt(Date createdAt) {
		CreatedAt = createdAt;
	}
	public ArrayList<CollectionCard> getListCollection() {
		return ListCollection;
	}
	public void setListCollection(ArrayList<CollectionCard> listCollection) {
		ListCollection = listCollection;
	}
	public void AddListCollection(CollectionCard item) {
		ListCollection.add(item);
	}
	public CollectionByDateDto(Date createdAt, ArrayList<CollectionCard> listCollection) {
		super();
		CreatedAt = createdAt;
		
		ListCollection = listCollection;
	}
	
	public int getQuantityCardById(long ColectionId) throws Exception{
		CollectionBo CBo = new CollectionBo();
		return CBo.GetQuantityById(ColectionId);
	}
	public String toStringGetDate() {
		Calendar cal = Calendar.getInstance();
		 cal.setTime(CreatedAt);
		 int month = cal.get(Calendar.MONTH) + 1;
		 int day = cal.get(Calendar.DAY_OF_MONTH);
		 int year = cal.get(Calendar.YEAR);
		return "Tháng " + month + " Năm " + year;
		
	}
	
	
}
