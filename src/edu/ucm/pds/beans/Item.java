package edu.ucm.pds.beans;

public class Item {

	private String itemName;
	private String itemDesc;
	private int itemId;
	private int price;
	private int qty;
	private int type;
	private int status;

	public Item(int iId,String iName,int cost,String iDesc){
		this.itemId=iId;
		this.itemName = iName;
		this.itemDesc = iDesc;
		this.qty = 1;
		this.type=1;
		this.price = cost;
	}
	
	public Item(){
		
	}


	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}


	public String getItemDesc() {
		return itemDesc;
	}


	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}



}
