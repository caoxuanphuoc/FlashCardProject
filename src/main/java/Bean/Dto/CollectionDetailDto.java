package Bean.Dto;

import java.sql.Date;
import java.util.ArrayList;

import Bean.Card;
import Bean.CollectionCard;

public class CollectionDetailDto {
	private Long Id;
	private Long UserId;
	private String CollectionName;
	private String Describe;
	private Long Rate;
	private boolean IsDelete;
	private int Status;
	private Date CreateAt;
	private ArrayList<Card> ListCard;
	public CollectionDetailDto() {
		// TODO Auto-generated constructor stub
	}
	public CollectionDetailDto(Long id, Long userId, String collectionName, String describe, Long rate,
			boolean isDelete, int status, Date createAt, ArrayList<Card> listCard) {
		super();
		Id = id;
		UserId = userId;
		CollectionName = collectionName;
		Describe = describe;
		Rate = rate;
		IsDelete = isDelete;
		Status = status;
		CreateAt = createAt;
		ListCard = listCard;
	}
	public CollectionDetailDto( CollectionCard col , ArrayList<Card> listCard) {
		super();
		Id = col.getId();
		UserId = col.getUserId();
		CollectionName = col.getCollectionName();
		Describe = col.getDescribe();
		Rate = col.getRate();
		IsDelete = col.getIsDelete();
		Status = col.getStatus();
		CreateAt = col.getCreateAt();
		ListCard = listCard;
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
	public ArrayList<Card> getListCard() {
		return ListCard;
	}
	public void setListCard(ArrayList<Card> listCard) {
		ListCard = listCard;
	}
	

}
