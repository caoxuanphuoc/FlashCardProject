package Bo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;

import javax.lang.model.element.Element;

import Bean.Card;
import Bean.CollectionCard;
import Bean.Dto.CollectionByDateDto;
import Bean.Dto.CollectionDetailDto;
import Bean.Dto.CollectionDtos.Collectiondto;
import Dao.CollectionDao;

public class CollectionBo {
	
	private CollectionDao Collec;
	public CollectionBo() {
		Collec = new CollectionDao();
	}
	//--------------Get-Detail Collection include List<card> by Id colection
	public CollectionDetailDto GetColectDetailById(Long ColectId) throws Exception {
		CollectionCard coll = Get(ColectId);
		CardBo cardb = new CardBo();
		ArrayList<Card> DSCardByID = cardb.GetAll(ColectId);
		CollectionDetailDto Dto = new CollectionDetailDto(coll, DSCardByID);
		return Dto;
	}
	//--------Get-by_id
	public CollectionCard Get(Long Id) throws Exception {
		return Collec.GetCollection(Id);
	}
	public Collectiondto GetDto(Long Id) throws Exception {
		CollectionCard ca=  Collec.GetCollection(Id);
		UserBo u = new UserBo();
		Collectiondto item = new Collectiondto(ca.getId(),ca.getUserId() ,u.GetUserNameById(ca.getUserId()), ca.getCollectionName(),
				ca.getDescribe(), ca.getRate(), ca.getIsDelete(), ca.getStatus(), ca.getCreateAt(), GetQuantityById(ca.getId()));
		return item;
	}
	//--------GET-ALL-------------------
	public ArrayList<Collectiondto> GetAll() throws Exception {
		ArrayList<CollectionCard> ls = Collec.GetAllCollection();
		ArrayList<Collectiondto> resls = new ArrayList<Collectiondto> ();
		for(CollectionCard ele : ls) {
			int quan = GetQuantityById(ele.getId());
			//Long userId, String collectionName, String describe, Long rate, boolean isDelete,
			//int status, Date createAt, int quantity;
			UserBo u = new UserBo();
			Collectiondto item = new Collectiondto(ele.getId(),ele.getUserId() ,u.GetUserNameById(ele.getUserId()), ele.getCollectionName(),
					ele.getDescribe(), ele.getRate(), ele.getIsDelete(), ele.getStatus(), ele.getCreateAt(), quan);
			resls.add(item);
		}
		return resls;
	}
	//--------GET-ALL-By-User-------
	public ArrayList<Collectiondto> GetAllByUser(Long IdUser) throws Exception {
		ArrayList<CollectionCard> ls = Collec.GetAllCollectionByUser(IdUser);
		ArrayList<Collectiondto> resls = new ArrayList<Collectiondto> ();
		for(CollectionCard ele : ls) {
			int quan = GetQuantityById(ele.getId());
			//Long userId, String collectionName, String describe, Long rate, boolean isDelete,
			//int status, Date createAt, int quantity;
			UserBo u = new UserBo();
			Collectiondto item = new Collectiondto(ele.getId(),ele.getUserId() ,u.GetUserNameById(ele.getUserId()), ele.getCollectionName(),
					ele.getDescribe(), ele.getRate(), ele.getIsDelete(), ele.getStatus(), null, quan);
			resls.add(item);
		}
		return resls;
	}
	//--------CREATE--------
	public int Create(Long userId, String collectionName, String describe) throws Exception {
		CollectionDao Collec2 = new CollectionDao();
		return Collec2.CreateCollectionCard(userId, collectionName, describe);
	}
	
	//--------DELETE--------
	public int Delete(Long Id) throws Exception {
		return Collec.DeleteCollectionCard(Id);
	}
	
	//--------UPDATE--------
	public int Update(CollectionCard CollectCard) throws Exception {
		return Collec.UpdateCollectionCard(CollectCard.getId(), CollectCard.getUserId(),
				CollectCard.getCollectionName(), CollectCard.getDescribe(), CollectCard.getRate(), CollectCard.getIsDelete(), CollectCard.getStatus(), CollectCard.getPassword());
	}
	
	//-----------GET-List-CollectionByDateDto
	public ArrayList<CollectionByDateDto> GetCollectionByDate(Long UserId , Boolean IsByMonth) throws Exception {
		ArrayList<CollectionByDateDto> DsbyDate = new ArrayList<CollectionByDateDto>();
		ArrayList<CollectionCard> dsColect = Collec.GetAllCollectionByUser(UserId);
		 Collections.sort(dsColect, new Comparator<CollectionCard>() {
	            @Override
	            public int compare(CollectionCard obj1, CollectionCard obj2) {
	                return obj2.getCreateAt().compareTo(obj1.getCreateAt());
	            }
	        });
		 int n = dsColect.size();
		 
		 for( int i=0;i<n;i++ ) {
			 int endloop=0;
			 Date day = dsColect.get(i).getCreateAt();
			 CollectionByDateDto ele = new CollectionByDateDto();
			 for(int j=i;j<n;j++) {
				 ele.setCreatedAt(day);
				 int ok = dsColect.get(j).getCreateAt().compareTo(day);
				 //---------Case By month
				 Calendar cal = Calendar.getInstance();
				 Calendar cal2 = Calendar.getInstance();
				 cal.setTime(day);
				 cal2.setTime(dsColect.get(j).getCreateAt());
				 int month1 = cal.get(Calendar.MONTH) + 1;
				 int year1 = cal.get(Calendar.YEAR);
				 
				 int month2 = cal2.get(Calendar.MONTH) + 1;
				 int year2 = cal2.get(Calendar.YEAR);
				 if(IsByMonth == true && month1 == month2 && year1 == year2)
					 ok = 0;		 	
				 //---------End case by month
				 if(ok == 0 ) {
					 ele.AddListCollection(dsColect.get(j));
					 if(j +1 ==n ) {
						 DsbyDate.add(ele);
						 i=j;
						 endloop =1;
						 break;
					 }
				 }else {
					 DsbyDate.add(ele);
					 i=j-1;
					 break;
				 }
				 if(endloop ==1)
					 break;
			 }
		 }
		 return DsbyDate;
	}
	public int GetQuantityById(long CollectId) throws Exception {
		return Collec.QuantityCard(CollectId);
	}
	public ArrayList<Collectiondto> Search(String KeyWord) throws Exception{
		ArrayList<Collectiondto> DsFilter = new ArrayList<Collectiondto>();
		if(KeyWord!=null) {
		KeyWord = KeyWord.trim().toLowerCase();
		ArrayList<Collectiondto> dsAll = GetAll();
		for(Collectiondto Item : dsAll) {
			if(Item.getCollectionName().trim().toLowerCase().contains(KeyWord) 
				  || Item.getDescribe().trim().toLowerCase().contains(KeyWord))
				DsFilter.add(Item);
		}
		}
		return DsFilter;
	}
}
